package com.timeformat.decorator;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

/**
 * TimeFormatDecorator is an Decorator Interface
 * Can be used to change the end result formats
 * 
 * @author Navneeth
 *
 */

public interface TimeFormatDecorator {
	String decorator(NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat, boolean extraTime);
}
