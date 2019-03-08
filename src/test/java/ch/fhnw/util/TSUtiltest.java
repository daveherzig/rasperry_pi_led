package ch.fhnw.util;

import org.junit.Assert;
import org.junit.Test;

public class TSUtiltest {

	@Test
	public void testConvertTimeStamp() {
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
}
