package com.timeformat.api;

import org.springframework.stereotype.Component;

/**
 * POJO Class that contains the response structure
 * @author Navneeth
 *
 */

@Component
public class TFResponse {

	private String outputTF;
	private ResponseStatus status;
	private String message;

	public TFResponse() {
	}	
	
	public TFResponse(String outputTF) {
		this.outputTF = outputTF;
	}	
	
	public TFResponse(String outputTF, ResponseStatus status) {
		this.outputTF = outputTF;
		this.status = status;
	}	

	public TFResponse(String outputTF, ResponseStatus status, String message) {
		this.outputTF = outputTF;
		this.status = status;
		this.message = message;
	}

	public String getOutputTF() {
		return outputTF;
	}

	public void setOutputTF(String outputTF) {
		this.outputTF = outputTF;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
