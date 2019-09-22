package com.timeformat.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

/**
 * NinetyMinuteMatchTFDecorator is a Decorator class 
 * Formats the Input Object to desired Output Format
 * Returns the Output Object of Type String
 * 
 * @author Navneeth
 *
 */

@Component
public class NinetyMinuteMatchTFDecorator implements TimeFormatDecorator {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());
		
	@Override
	public String decorator(NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat, boolean extraTime) {
		logger.info("Entering decorator() Method...");
		return outputTFDecorator(ninetyMinuteMatchTimeFormat, extraTime);
	}	

	public String outputTFDecorator(NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat, boolean extraTime) {
		logger.info("Entering outputTFDecorator() Method...");
		String outputTF = null;
		if(extraTime) {
			outputTF = String.format("%02d:%02d +%02d:%02d - %s", ninetyMinuteMatchTimeFormat.getMatchMinutes(),
					ninetyMinuteMatchTimeFormat.getMatchSeconds(), ninetyMinuteMatchTimeFormat.getExtraMinutes(), ninetyMinuteMatchTimeFormat.getExtraSeconds(), 
					ninetyMinuteMatchTimeFormat.getMatchState());
		}else {
			outputTF = String.format("%02d:%02d - %s", ninetyMinuteMatchTimeFormat.getMatchMinutes(),
					ninetyMinuteMatchTimeFormat.getMatchSeconds(), ninetyMinuteMatchTimeFormat.getMatchState());
		}
		logger.debug("Formatted Output: " + outputTF);
		return outputTF;
	}
}
