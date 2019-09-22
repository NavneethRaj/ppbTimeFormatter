package com.timeformat.validation;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

/**
 * 
 * Interface to Validate Time of different Formats
 * @author Navneeth
 *
 */
public interface TimeFormatValidate {
	
	NinetyMinuteMatchTimeFormat timeFormatCheck(String inputTime);

}