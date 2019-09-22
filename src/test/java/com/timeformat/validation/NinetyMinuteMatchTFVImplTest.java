package com.timeformat.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NinetyMinuteMatchTFVImplTest {

    @Autowired
	private TimeFormatValidate timeFormatValidate;
	
	@Test(expected=NullPointerException.class)
	public void testFormat() {
		assertEquals("[H2]" , timeFormatValidate.timeFormatCheck("[H2] 90:59.789").getMatchState());
		assertEquals(null, timeFormatValidate.timeFormatCheck("[ZG] 90:59.789").getMatchState());
	}
}
