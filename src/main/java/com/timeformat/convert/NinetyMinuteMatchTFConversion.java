package com.timeformat.convert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gameperiod.NinetyMinuteMatchPeriod;
import com.timeformat.api.ResponseStatus;
import com.timeformat.api.TFResponse;
import com.timeformat.decorator.NinetyMinuteMatchTFDecorator;
import com.timeformat.validation.NinetyMinuteMatchTimeValidation;
import com.timeformat.validation.TimeFormatValidate;

/**
 * NinetyMinuteMatchTFConversion class is a wrapper to call other Validation functions 
 * and to Calculate time from the input Object
 * 
 * @author Navneeth
 *
 */

@Component
public class NinetyMinuteMatchTFConversion {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
	
	private final int HALFTIME = 45;
	private final int FULLTIME = 90;
	private final int SECONDS = 60;
	private boolean isExtraTime = false;
	private String message = null;
	private final String EDGECASE = "EDGECASE";

	@Autowired
	private TimeFormatValidate timeFormatValidate;

	@Autowired
	private NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat;

	@Autowired
	private NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation;
	
	@Autowired
	private NinetyMinuteMatchTFDecorator ninetyMinuteMatchTFDecorator;

	@Autowired
	private TFResponse tfResponse;	

	public TFResponse convertTimeFormat(String inputTime) {
		logger.info("Entering convertTimeFormat method...");
		ninetyMinuteMatchTimeFormat = timeFormatValidate.timeFormatCheck(inputTime);
		logger.debug("Entered String is Valid : " + ninetyMinuteMatchTimeFormat);
		
		// Local Initialization
		isExtraTime = false;
		message = null;

		if (ninetyMinuteMatchTimeFormat != null) {
			// Changing the Match State to Long Form
			ninetyMinuteMatchTimeFormat.setMatchState(NinetyMinuteMatchPeriod
					.getMatchLongForm(ninetyMinuteMatchTimeFormat.getMatchState().substring(1, 3)));
			
			// Message that contains detail about what the error is based on the input data
			message = ninetyMinuteMatchTimeValidation.matchTimeValid(ninetyMinuteMatchTimeFormat);
			if (message == null || EDGECASE.equalsIgnoreCase(message)) {
				// Adjust Time
				calculateTimeWrapper();
				String outputTF = ninetyMinuteMatchTFDecorator.decorator(ninetyMinuteMatchTimeFormat, isExtraTime);
				tfResponse = new TFResponse(outputTF, ResponseStatus.OK, "MATCH_TIME");
			} else {
				// Response if there is any invalid numbers in the input
				tfResponse = new TFResponse("INVALID", ResponseStatus.ERROR, message);
			}
			return tfResponse;
		} else {
			// Response if the format is not valid
			tfResponse = new TFResponse("INVALID", ResponseStatus.ERROR, "TIME_FORMAT_INVALID");
			return tfResponse;
		}
	}
	
	private void calculateTimeWrapper() {
		logger.info("Entering calculateTimeWrapper() Method...");
		actualTimeCalcualtion();
	}

	private void actualTimeCalcualtion() {
		logger.info("Entering actualTimeCalcualtion() Method...");
		switch (ninetyMinuteMatchTimeFormat.getMatchState()) {
		case "FIRST_HALF":
			calculateTime(ninetyMinuteMatchTimeFormat.getMatchMinutes(), ninetyMinuteMatchTimeFormat.getMatchSeconds(), HALFTIME);
			break;
		case "SECOND_HALF":
			calculateTime(ninetyMinuteMatchTimeFormat.getMatchMinutes(), ninetyMinuteMatchTimeFormat.getMatchSeconds(), FULLTIME);
			break;
		// Other time slots does not need any changes since all checks are done pre-hand	
		default:
		}
	}
	
	private void calculateTime(int minutes, int seconds, int duration) {
		// Check if extraTime
		isExtraTime = (minutes >= duration);
		boolean isIncrementTime = calculateSeconds(seconds, isExtraTime);
		calculateMinutes(minutes, duration, isExtraTime, isIncrementTime);
	}

	private void calculateMinutes(int minutes, int duration, boolean isExtraTime, boolean isIncrementTime) {
		logger.info("Entering calculateMinutes() Method...");
		if (isExtraTime) {
			// If extra time, then add the seconds to extratime slot and keep regular time constant 
			ninetyMinuteMatchTimeFormat.setMatchMinutes(duration);
			ninetyMinuteMatchTimeFormat.setExtraMinutes(isIncrementTime ? ((minutes + 1) - duration) : (minutes - duration));
		}else {
			ninetyMinuteMatchTimeFormat.setMatchMinutes(isIncrementTime ? (minutes + 1) : (minutes));
		}
	}

	private boolean calculateSeconds(int seconds, boolean isExtraTime) {
		logger.info("Entering calculateSeconds() Method...");
		// Check if the seconds is 60, to add +1 to minutes
		boolean isSecondsFull = (seconds == SECONDS);
		if(isExtraTime) {
			// If extra time, then add the seconds to extratime slot and keep regular time constant 
			ninetyMinuteMatchTimeFormat.setMatchSeconds(0);
			ninetyMinuteMatchTimeFormat.setExtraSeconds(isSecondsFull ? 0 : seconds);	
		}else {
			ninetyMinuteMatchTimeFormat.setMatchSeconds(isSecondsFull ? 0 : seconds);
		}
		return isSecondsFull;
	}
}
