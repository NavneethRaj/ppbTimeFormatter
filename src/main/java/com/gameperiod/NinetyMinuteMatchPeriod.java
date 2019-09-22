package com.gameperiod;

/**
 * ENUM to hold short_form and long_form
 * @author Navneeth
 *
 */

public enum NinetyMinuteMatchPeriod {

	PM("PRE_MATCH"), 
	H1("FIRST_HALF"), 
	HT("HALF_TIME"), 
	H2("SECOND_HALF"), 
	FT("FULL_TIME");

	private String longForm;

	NinetyMinuteMatchPeriod(String longForm) {
		this.longForm = longForm;
	}

	// Method to return the matched enum and its value
	public static String getMatchLongForm(String shortForm) {
		for (NinetyMinuteMatchPeriod lf : values()) {
			if (lf.name().equals(shortForm)) {
				return lf.longForm;
			}
		}
		return null;
	}
}
