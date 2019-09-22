package com.timeformat.decorator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NinetyMinuteMatchTFDecoratorTest {
    
    @Autowired
    private TimeFormatDecorator timeFormatDecorator;
    
	@Test
	public void testDecorator() {
		NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 34, 23);
	    String outputFormat = timeFormatDecorator.decorator(ninetyMinuteMatchTimeFormat, false);
	    assertEquals("34:23 - HALF_TIME", outputFormat);
	    ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 45, 00, 1, 12);
	    outputFormat = timeFormatDecorator.decorator(ninetyMinuteMatchTimeFormat, true);
	    assertEquals("45:00 +12:00 - HALF_TIME", outputFormat);
	}
}