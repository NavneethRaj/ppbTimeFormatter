package com.timeformat.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.timeformat.api.TFResponse;
import com.timeformat.convert.NinetyMinuteMatchTFConversion;
import com.timeformat.convert.NinetyMinuteMatchTimeFormat;
import com.timeformat.decorator.NinetyMinuteMatchTFDecorator;
import com.timeformat.service.TimeFormatServiceImpl;
import com.timeformat.validation.NinetyMinuteMatchTimeValidation;
import com.timeformat.validation.TimeFormatValidate;

@RunWith(SpringRunner.class)
@WebMvcTest(TimeFormatController.class)
public class TimeFormatControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TimeFormatValidate timeFormatValidate;

	@MockBean
	private NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat;

	@MockBean
	private NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation;

	@MockBean
	private NinetyMinuteMatchTFDecorator ninetyMinuteMatchTFDecorator;

	@MockBean
	private TFResponse tfResponse;

	@MockBean
	private TimeFormatServiceImpl timeFormatServiceImpl;

	@MockBean
	private NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;

	@Test
	public void testtimeformatterPage() throws Exception {
		mockMvc.perform(get("/matchTimeConvert")).andExpect(status().isOk()).andExpect(view().name("timeformatter"))
				.andExpect(content().string(containsString("Enter The Time You Want To Convert")));
	}

}
