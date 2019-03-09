package ch.fhnw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Auxiliary methods for time conversion
 * @author David Herzig
 */
public class TSUtil {
	
	/**
	 * Convert ms timestamp to readable string
	 * @param timestamp ms since 1.Jan.1970
	 * @return date and time String
	 */
    public static String convertTimeStamp(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String result  = dateFormat.format(new Date(timestamp));       
        return result;
    }
 
	/**
	 * Convert string date and time to ms
	 * @param year years string format
	 * @param year years string format
	 * @param month month string format
	 * @param day day string format
	 * @param hour hour string format
	 * @param minute minute string format
	 * @param second second string format
	 * @return timestamp ms since 1.Jan.1970
	 */
    public static long getTimeStamp(String year, String month, String day, String hour, String minute, String second) {
        String timeStr = year + "-" + month + "-" + day + ":" + hour + "-" + minute + "-" + second;
        //String timeStr = day + "-" + month + "-" + year + " um " + hour + ":" + minute + ":" + second;
        System.out.println(timeStr);
        Date result;
        try {
            result = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").parse(timeStr);
            //result = new SimpleDateFormat("dd-MM-yyyy um HH:mm:ss").parse(timeStr);
        } catch (ParseException ex) {
            return -1;
        }
        return result.getTime();
    }
}
