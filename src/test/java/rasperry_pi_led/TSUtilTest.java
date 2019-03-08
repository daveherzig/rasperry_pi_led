package rasperry_pi_led;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.fhnw.util.TSUtil;

public class TSUtilTest {

	@Test
	public void testConvertTimeStamp() {
		long timestamp = 1552062128688l;
		String expectedValue = "08-03-2019 17:22:08";
		String value = TSUtil.convertTimeStamp(timestamp);
		assertEquals(expectedValue, value);
	}

}
