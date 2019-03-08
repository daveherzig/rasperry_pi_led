package ch.fhnw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author David Herzig
 */
public class TSUtil {

	public static String convertTimeStamp(long timestamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String result = dateFormat.format(new Date(timestamp))+"-";
		return result;
	}

	public static long getTimeStamp(String year, String month, String day, String hour, String minute, String second) {
		String timeStr = year + "-" + month + "-" + day + ":" + hour + "-" + minute + "-" + second;
		System.out.println(timeStr);
		Date result;
		try {
			result = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").parse(timeStr);
		} catch (ParseException ex) {
			return -1;
		}
		return result.getTime();
	}
}
