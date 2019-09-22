package com.timeformat.convert;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * POJO class to hold Match Time
 * @author Navneeth
 *
 */

@Component
@Scope("prototype")
public class NinetyMinuteMatchTimeFormat {

	private String matchState;
	private int matchMinutes;
	private int matchSeconds;
	private int matchMilliSeconds;	
	private int extraMinutes;
	private int extraSeconds;

	//Constructors
	public NinetyMinuteMatchTimeFormat() {
	}	

	public NinetyMinuteMatchTimeFormat(String matchState) {
		this.matchState = matchState;
	}	
	
	public NinetyMinuteMatchTimeFormat(String matchState, int matchMinutes) {
		this.matchState = matchState;
		this.matchMinutes = matchMinutes;
	}
	
	public NinetyMinuteMatchTimeFormat(String matchState, int matchMinutes, int matchSeconds) {
		this.matchState = matchState;
		this.matchMinutes = matchMinutes;
		this.matchSeconds = matchSeconds;
	}	
	
	public NinetyMinuteMatchTimeFormat(String matchState, int matchMinutes, int matchSeconds, int matchMilliSeconds) {
		this.matchState = matchState;
		this.matchMinutes = matchMinutes;
		this.matchSeconds = matchSeconds;
		this.matchMilliSeconds = matchMilliSeconds;
	}	
	public NinetyMinuteMatchTimeFormat(String matchState, int matchMinutes, int matchSeconds, int matchMilliSeconds,
			int extraMinutes) {
		this.matchState = matchState;
		this.matchMinutes = matchMinutes;
		this.matchSeconds = matchSeconds;
		this.matchMilliSeconds = matchMilliSeconds;
		this.extraMinutes = extraMinutes;
	}

	public NinetyMinuteMatchTimeFormat(String matchState, int matchMinutes, int matchSeconds, int matchMilliSeconds,
			int extraMinutes, int extraSeconds) {
		this.matchState = matchState;
		this.matchMinutes = matchMinutes;
		this.matchSeconds = matchSeconds;
		this.matchMilliSeconds = matchMilliSeconds;
		this.extraMinutes = extraMinutes;
		this.extraSeconds = extraSeconds;
	}

	//Getters and Setters
	public String getMatchState() {
		return matchState;
	}

	public void setMatchState(String matchState) {
		this.matchState = matchState;
	}

	public int getMatchMinutes() {
		return matchMinutes;
	}

	public void setMatchMinutes(int matchMinutes) {
		this.matchMinutes = matchMinutes;
	}

	public int getMatchSeconds() {
		return matchSeconds;
	}

	public void setMatchSeconds(int matchSeconds) {
		this.matchSeconds = matchSeconds;
	}
	
	public int getMatchMilliSeconds() {
		return matchMilliSeconds;
	}

	public void setMatchMilliSeconds(int matchMilliSeconds) {
		this.matchMilliSeconds = matchMilliSeconds;
	}

	public int getExtraMinutes() {
		return extraMinutes;
	}

	public void setExtraMinutes(int extraMinutes) {
		this.extraMinutes = extraMinutes;
	}

	public int getExtraSeconds() {
		return extraSeconds;
	}

	public void setExtraSeconds(int extraSeconds) {
		this.extraSeconds = extraSeconds;
	}
}
