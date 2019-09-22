package com.timeformat.decorator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

@RunWith(SpringRunner.class)
public class NinetyMinuteMatchTFDecoratorTest {

    @TestConfiguration
    static class NinetyMinuteMatchTFConversionTestContextConfiguration {   
        @Bean
        public TimeFormatDecorator timeFormatDecorator() {
            return new NinetyMinuteMatchTFDecorator();
        }
    }
    
    @Autowired
    TimeFormatDecorator timeFormatDecorator;
    
	@Test
	public void testDecorator() {
		NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 34, 23);
	    String outputFormat = timeFormatDecorator.decorator(ninetyMinuteMatchTimeFormat, false);
	    System.out.println(outputFormat);
	    ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 45, 00, 1, 12);
	    outputFormat = timeFormatDecorator.decorator(ninetyMinuteMatchTimeFormat, true);
	    System.out.println(outputFormat);
	}
}