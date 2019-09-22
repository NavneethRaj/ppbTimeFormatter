package com.timeformat.validation;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

/**
 * NinetyMinuteMatchTFVImpl performs Validation for the input time format
 * returns boolean value if the string matches the format else false
 * 
 * @author Navneeth
 *
 */

@Component
public class NinetyMinuteMatchTFVImpl implements TimeFormatValidate {

	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	// Pattern to match the input string
	private final String pattern = "^\\s*(\\[[PMH12FT]{2}\\]) ([0-9]{1,3}):(([0-5]{1}[0-9]{1}).([0-9]{3}))";

	@Autowired
	private NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat;

	@Override
	public NinetyMinuteMatchTimeFormat timeFormatCheck(String inputTime) {

		logger.info("Entering timeFormatCheck() method...");

		// Create a Pattern object
		Pattern matchTimeFormat = Pattern.compile(pattern);

		// Now create matcher object.
		Matcher m = matchTimeFormat.matcher(inputTime);

		try {
			if (m.find()) {
				// Whole Input String
				logger.info("Input String: " + m.group(0));

				// Match Short Form
				logger.debug("First Group: " + m.group(1));
				ninetyMinuteMatchTimeFormat.setMatchState(m.group(1));

				// Minutes
				logger.debug("Second Group: " + m.group(2));
				ninetyMinuteMatchTimeFormat.setMatchMinutes(Integer.parseInt(m.group(2)));

				// Seconds + MilliSeconds
				logger.debug("Third Group: " + m.group(3));
				ninetyMinuteMatchTimeFormat.setMatchSeconds(Math.round(Float.parseFloat(m.group(3))));

				// Seconds
				logger.debug("Fourth Group: " + m.group(4));

				// MilliSeconds
				logger.debug("Second Group: " + m.group(5));
				ninetyMinuteMatchTimeFormat.setMatchMilliSeconds(Integer.parseInt(m.group(5)));

				return ninetyMinuteMatchTimeFormat;
			} else {
				logger.info("NO MATCH");
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.info("NO MATCH");
			return null;
		}
	}
}
