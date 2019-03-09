package ch.fhnw.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Utility class for the Raspberry Pi LED Project
 * @author David Herzig
 */
public class TSUtil {
    
	private static final Logger LOG = LogManager.getLogger(TSUtil.class);
	
	/**
	 * Wandelt timestamp (long in ms) in ein lesbares Format (string in dd-MM-yy HH:mm:ss). 
	 * @param timestamp
	 * @return
	 */
    public static String convertTimeStamp(long timestamp) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String result  = dateFormat.format(new Date(timestamp));
        return result;
    }
    
    /**
     * TimeStamp ausgeben.
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return
     */
    public static long getTimeStamp(String year, String month, String day, String hour, String minute, String second) {
        String timeStr = year + "-" + month + "-" + day + ":" + hour + "-" + minute + "-" + second;
        System.out.println(timeStr);
        assert !timeStr.isEmpty();
        Date result;
        try {
            result = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss").parse(timeStr);
        } catch (ParseException ex) {
        	LOG.error("Invalid timestamp",ex);
        	return -1;
        }
        return result.getTime();
    }
}
