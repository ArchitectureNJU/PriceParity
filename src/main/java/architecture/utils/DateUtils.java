package architecture.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date & time utils
 * @author cuihao
 */
public class DateUtils {
    private static SimpleDateFormat fullFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String longToStringFull(long time) {
        return fullFormat.format(new Date(time));
    }
    public static String longToStringSimple(long time) {
        return simpleFormat.format(new Date(time));
    }
    public static String dateToString(Date date) {
        return simpleFormat.format(date);
    }
    public static long StringFullToLong(String full){
        Date date = null;
        try {
            date = fullFormat.parse(full);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
}
