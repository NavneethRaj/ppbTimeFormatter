package com.timeformat.validation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

@RunWith(SpringRunner.class)
public class NinetyMinuteMatchTimeValidationTest {

    @TestConfiguration
    static class NinetyMinuteMatchTimeValidationContextConfiguration {
        @Bean
        public NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation() {
            return new NinetyMinuteMatchTimeValidation();
        }
    }
    
    @Autowired
    NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation;
    
	@Test
	public void matchTimeValid() {
		NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("PRE_MATCH", 0, 12);
		assertEquals("PRE_MATCH should be \"[PM] 00:00.000\"",ninetyMinuteMatchTimeValidation.matchTimeValid(ninetyMinuteMatchTimeFormat));
		
		ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 45, 12);
		assertEquals("HALF_TIME should be \"[HT] 45:00.000\"", ninetyMinuteMatchTimeValidation.matchTimeValid(ninetyMinuteMatchTimeFormat));
	
		ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("FULL_TIME", 90, 12);
		assertEquals("FULL_TIME should be \"[FT] 90:00.000\"", ninetyMinuteMatchTimeValidation.matchTimeValid(ninetyMinuteMatchTimeFormat));
	}

}
