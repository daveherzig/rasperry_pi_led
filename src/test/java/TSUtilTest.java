//package rasperry_pi_led_2;

import org.junit.Test;
import ch.fhnw.util.TSUtil;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TSUtilTest {

	
	@Test
	public void testConvertTimestamp() {
		long timestamp = 1552062128688l;
		String expectedValue = "08-03-2019 17:22:08";
		String valueResult = TSUtil.convertTimeStamp(timestamp);
		Assert.assertEquals(expectedValue,valueResult);
	}
	
}
