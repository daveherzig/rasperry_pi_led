//package rasperry_pi_led_2;

import org.junit.Test;
import ch.fhnw.util.TSUtil;
import static org.junit.Assert.*;

public class TSUtilTest {

	
	@Test
	public void testConvertTimestamp() {
		long timestamp = 1552062128688l;
		String expectedValue = "08-03-2019 17:22:08";
		String value = TSUtil.convertTimeStamp(timestamp);
		assertEquals(expectedValue, value);
	}
	
}
