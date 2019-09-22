package com.timeformat;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.api.TFRequestImpl;
import com.timeformat.api.TFResponse;
import com.timeformat.convert.NinetyMinuteMatchTFConversion;
import com.timeformat.convert.NinetyMinuteMatchTimeFormat;
import com.timeformat.decorator.NinetyMinuteMatchTFDecorator;
import com.timeformat.service.TimeFormatServiceImpl;
import com.timeformat.validation.NinetyMinuteMatchTimeValidation;
import com.timeformat.validation.TimeFormatValidate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PpdAssignmentApplicationTest {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

	@Autowired
	TimeFormatValidate timeFormatValidate;

	@Autowired
	NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat;

	@Autowired
	NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation;

	@Autowired
	NinetyMinuteMatchTFDecorator ninetyMinuteMatchTFDecorator;

	@Autowired
	TFResponse tfResponse;

	@Autowired
	TimeFormatServiceImpl timeFormatServiceImpl;

	@Autowired
	NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;

	// given
	String[] inputTimeFormat = { "[PM] 0:00.000", "[PM] 0:00.001", "[PM] 00:01.000", "[H1] 00:00.001", "[H1] 0:15.025", "[H1] 3:07.513", "[H1] 45:00.001", "[H1] 46:15.752",
			"[HT] 45:00.000", "[HT] 45:00.001", "[H2] 5:59.412", "[H2] 45:00.001", "[H2] 45:00.500", "[H2] 66:59.789", "[H2] 89:59.412", "[H2] 90:00.908", "[FT] 90:00.000", "[FT] 99:59.412", "[H2] 95:59.412", "90:00", "[H3] 90:00.000",
			"[PM] -10:00.000", "FOO", "[TH] 9:59.412" };

	String[] expectedTimeFormat = { "00:00 - PRE_MATCH", "INVALID", "INVALID", "00:00 - FIRST_HALF", "00:15 - FIRST_HALF", "03:08 - FIRST_HALF",
			"45:00 +00:00 - FIRST_HALF", "45:00 +01:16 - FIRST_HALF", "45:00 - HALF_TIME", "INVALID", "INVALID",  "45:00 - SECOND_HALF", "45:01 - SECOND_HALF",
			"67:00 - SECOND_HALF", "89:59 - SECOND_HALF", "90:00 +00:01 - SECOND_HALF", "90:00 - FULL_TIME", "INVALID", "90:00 +05:59 - SECOND_HALF", "INVALID", "INVALID", "INVALID", "INVALID", "INVALID" };

	@Test
	public void integrationTest() {
		List<TFRequestImpl> tfRequestImpl = new ArrayList<TFRequestImpl>();
		String[] actualOutput = new String[inputTimeFormat.length];
		for (int i = 0; i < inputTimeFormat.length; i++) {
			tfRequestImpl.add(new TFRequestImpl(inputTimeFormat[i]));
			
			//when
			actualOutput[i] = timeFormatServiceImpl.timeFormatter(tfRequestImpl.get(i)).getBody().getOutputTF();
			
			//then
			assertEquals(expectedTimeFormat[i], actualOutput[i]);
		}
		
		String format = "|%1$-15s|%2$-27s|%3$-27s|\n";
		logger.info(String.format(format, "Input Value", "Actual Value", "Expected Value"));
		for(int j = 0; j < actualOutput.length; j++) {
			logger.info((String.format(format, inputTimeFormat[j], actualOutput[j], expectedTimeFormat[j])));
		}
		/*
		tfRequestImpl.forEach(tf -> {
			System.out.println(timeFormatServiceImpl.timeFormatter(tf).getBody().getOutputTF());
		});
		*/
	}
}
