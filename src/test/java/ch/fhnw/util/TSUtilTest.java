package ch.fhnw.util;

import org.junit.Test;

import junit.framework.Assert;

public class TSUtilTest {
	@Test
	public void testConvertTimestamp () {
		long[] arrTimeStamp;
		arrTimeStamp = new long[3];
		String[] arrExpected;
		arrExpected = new String[3];
		String[] arrActual;
		arrActual = new String[3];
		
		arrTimeStamp[0] = 1552062128688l;
		arrTimeStamp[1] = 1l;
		arrTimeStamp[2] = 9999999999999l;
		arrExpected[0] = "08-03-2019 17:22:08";
		arrExpected[1] = "01-01-1970 01:00:00";
		arrExpected[2] = "05-20-318857 05:46:39";
		
		for (int i = 0; i < 2; i++) {
			arrActual[i] = TSUtil.convertTimeStamp(arrTimeStamp[i]);
			Assert.assertEquals(arrExpected[i], arrActual[i]);
		}		
	}
	
	@Test
	public void testGetTimeStamp () {
		int numTests = 1;
		String[] arrInputYear;
		arrInputYear = new String[numTests];
		String[] arrInputMonth;
		arrInputMonth = new String[numTests];
		String[] arrInputDay;
		arrInputDay = new String[numTests];
		String[] arrInputHour;
		arrInputHour = new String[numTests];
		String[] arrInputMinute;
		arrInputMinute = new String[numTests];
		String[] arrInputSecond;
		arrInputSecond = new String[numTests];
		
		long[] arrTimeStampExpected;
		arrTimeStampExpected = new long[numTests];
		long[] arrTimeStampActual;
		arrTimeStampActual = new long[numTests];

		arrInputYear[0] = "1970";
		arrInputMonth[0] = "01";
		arrInputDay[0] = "01";
		arrInputHour[0] = "01";
		arrInputMinute[0] = "00";
		arrInputSecond[0] = "01";
		arrTimeStampExpected[0] = 1000l;
		
		for (int i = 0; i < numTests; i++) {
			arrTimeStampActual[i] = TSUtil.getTimeStamp(arrInputYear[i], arrInputMonth[i], arrInputDay[i], arrInputHour[i], arrInputMinute[i], arrInputSecond[i]);
			Assert.assertEquals(arrTimeStampExpected[i], arrTimeStampActual[i]);
		}
	}
}
