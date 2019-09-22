package com.timeformat.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.api.TFRequestImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeFormatServiceImplTest {

	@Autowired
	TimeFormatServiceImpl timeFormatServiceImpl;
	
	@Test
	public void timeFormatter() {
		assertEquals("90:00 - FULL_TIME" , timeFormatServiceImpl.timeFormatter(new TFRequestImpl("[FT] 90:00.000")).getBody().getOutputTF());
		assertEquals("INVALID" , timeFormatServiceImpl.timeFormatter(new TFRequestImpl("[H2] 110:00.000")).getBody().getOutputTF());
	}

}
