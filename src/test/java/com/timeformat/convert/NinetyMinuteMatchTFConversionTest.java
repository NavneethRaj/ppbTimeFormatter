package com.timeformat.convert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.decorator.NinetyMinuteMatchTFDecorator;
import com.timeformat.validation.NinetyMinuteMatchTimeValidation;
import com.timeformat.validation.TimeFormatValidate;

@RunWith(SpringRunner.class)
public class NinetyMinuteMatchTFConversionTest {
	
	String inputTF = "[HT] 90:59.789";

    @TestConfiguration
    static class NinetyMinuteMatchTFConversionTestContextConfiguration {
        @Bean
        public NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion() {
            return new NinetyMinuteMatchTFConversion();
        }
    }
	
    @Autowired
    NinetyMinuteMatchTFConversion ninetyMinuteMatchTFConversion;
    
    @MockBean
	NinetyMinuteMatchTimeValidation ninetyMinuteMatchTimeValidation;
	
	@MockBean
	NinetyMinuteMatchTFDecorator ninetyMinuteMatchTFDecorator;    

    @MockBean
	TimeFormatValidate timeFormatValidate;
    
	@Test
	public void testConvertTimeFormat() {
		NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat = new NinetyMinuteMatchTimeFormat("HALF_TIME", 34, 23);
		Mockito.when(timeFormatValidate.timeFormatCheck(Mockito.anyString())).thenReturn(ninetyMinuteMatchTimeFormat);
		Mockito.when(ninetyMinuteMatchTimeValidation.matchTimeValid(Mockito.any())).thenReturn(null);
		// doReturn(inputTF).when(ninetyMinuteMatchTimeFormat).getMatchState();
	}

}
