package ch.fhnw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author David Herzig
 */
public class TSUtil {
    
	/**
	 * This function returns the timestamp in a human readable format
	 * @param timestamp	in miliseconds
	 * @return	Human readable Date and Time
	 */
	public static String convertTimeStamp(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String result  = dateFormat.format(new Date(timestamp));
        assert !result.isEmpty() : "KeinResultat_GAGA";
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
