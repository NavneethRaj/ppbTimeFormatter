package com.timeformat.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.timeformat.convert.NinetyMinuteMatchTimeFormat;

@RunWith(SpringRunner.class)
public class NinetyMinuteMatchTFVImplTest {
	
    @TestConfiguration
    static class NinetyMinuteMatchTFVImplTestContextConfiguration {
        @Bean
        public TimeFormatValidate timeFormatValidate() {
            return new NinetyMinuteMatchTFVImpl();
        }
    }
	
    @MockBean
    private NinetyMinuteMatchTimeFormat ninetyMinuteMatchTimeFormat;

    @Autowired
	TimeFormatValidate timeFormatValidate;
	
	@Test
	public void testFormat() {
		timeFormatValidate.timeFormatCheck("[H2] 90:59.789");
	}
}
