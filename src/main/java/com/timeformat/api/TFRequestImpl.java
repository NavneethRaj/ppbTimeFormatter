package com.timeformat.api;

/**
 * POJO Class that contains the request structure
 * @author Navneeth
 *
 */

public class TFRequestImpl {

	private String inputTF;
	
	public TFRequestImpl() {
	}

	public TFRequestImpl(String inputTF) {
		this.inputTF = inputTF;
	}

	public String getInputTF() {
		return inputTF;
	}

	public void setInputTF(String inputTF) {
		this.inputTF = inputTF;
	}
}
