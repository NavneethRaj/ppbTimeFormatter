package com.timeformat.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

/**
 * NinetyMinuteMatchTimeValidation class performs validation on the input time
 * It checks if the entered value matches the period of match
 * 
 * @author Navneeth
 *
 */
@Component
public class NinetyMinuteMatchTimeValidation {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	private final int HALFTIME = 45;
	private final int FULLTIME = 90;
	private final String EDGECASE = "EDGECASE";

	public String matchTimeValid(NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat) {

		logger.info("Entering matchTimeValid() method...");

		// Local copy of Minutes and Seconds
		int minutes = ninetyMinuteMatchTimeFormat.getMatchMinutes();
		int seconds = ninetyMinuteMatchTimeFormat.getMatchSeconds();
		int milliseconds = ninetyMinuteMatchTimeFormat.getMatchMilliSeconds();

		// Message returned to user based on the Validity of values
		String message = null;

		// When getMatchState() returns null
		try {
			switch (ninetyMinuteMatchTimeFormat.getMatchState()) {
			case "PRE_MATCH":
				if (!(minutes == 0 && seconds == 0 && milliseconds == 0)) {
					message = "PRE_MATCH should be '[PM] 00:00.000'";
				}
				break;
			case "FIRST_HALF":
				if (minutes > 54) {
					message = "FIRST_HALF should have minutes less than 55, maximum is '[H1] 54:59.999'";
				} else if (minutes == HALFTIME && (seconds >= 0 && seconds <= 59) && milliseconds != 0) {
					message = EDGECASE;
				}
				break;
			case "HALF_TIME":
				if (!(minutes == HALFTIME && seconds == 0 && milliseconds == 0)) {
					message = "HALF_TIME should be '[HT] 45:00.000'";
				}
				break;
			case "SECOND_HALF":
				if (minutes > 99 || minutes < 45 || (minutes == 45 && seconds <= 0 && milliseconds <= 0)) {
					message = "SECOND_HALF should have minutes in between 45 - 100, minimum is '[H2] 45:00.001' and maximum is '[H2] 99:59.999'";
				} else if (minutes == FULLTIME && (seconds >= 0 && seconds <= 59) && milliseconds != 0) {
					message = EDGECASE;
				}
				break;
			case "FULL_TIME":
				if (!(minutes == FULLTIME && seconds == 0)) {
					message = "FULL_TIME should be '[FT] 90:00.000'";
				}
				break;
			default:
				message = "INVALID";
				break;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			message = "INVALID";
		}
		return message;
	}
}
