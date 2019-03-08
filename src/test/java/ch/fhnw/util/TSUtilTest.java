package ch.fhnw.util;


import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TSUtilTest {

	// bla
	@Test
	public void testConvertTimeStamp() {
       long timestamp = 1551733443855l;
       String expectedValue = "04-03-2019 22:04:03";
       String value = TSUtil.convertTimeStamp(timestamp);
       assertEquals(expectedValue, value);
	}
	
}
