package com.timeformat.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.timeformat.api.TFRequestImpl;
import com.timeformat.api.TFResponse;
import com.timeformat.convert.NinetyMinuteMatchTFConversion;

/**
 * TimeFormatServiceImpl class is a REST service class
 * Can make the api calls and get the response
 * Sample JSON Request
 * {inputTF": "[H2] 66:45.789"}
 * @author Navneeth
 *
 */

@RestController
public class TimeFormatServiceImpl {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	private NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;

	@RequestMapping(value = "/matchtimeformatter", method = RequestMethod.POST)
    public ResponseEntity<TFResponse> timeFormatter(@RequestBody TFRequestImpl tfRequestImpl) {
		logger.info("Entering timeFormatter() Method...");
		TFResponse tfResponse = ninetyMinuteMatchTFConversion.convertTimeFormat(tfRequestImpl.getInputTF());
		return new ResponseEntity<TFResponse>(tfResponse, HttpStatus.ACCEPTED);
	}
}
