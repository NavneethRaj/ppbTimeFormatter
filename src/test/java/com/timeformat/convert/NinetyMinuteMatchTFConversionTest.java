package com.timeformat.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NinetyMinuteMatchTFConversionTest {

	@Autowired
	private NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;

	@Test
	public void testConvertTimeFormat() {
		assertEquals("INVALID", (ninetyMinuteMatchTFConversion.convertTimeFormat("[HT] 90:59.789").getOutputTF()));
		assertEquals("45:00 +00:00 - FIRST_HALF", (ninetyMinuteMatchTFConversion.convertTimeFormat("[H1] 45:00.001").getOutputTF()));
	}

}
