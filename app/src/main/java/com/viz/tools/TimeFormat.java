package com.viz.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by viz on 2014/11/25.
 */
public class TimeFormat {
    public static final String TIMEZONE_SHANGHAI = "Asia/Shanghai";

    /**
     * 将字符串数据转化为毫秒数
     *
     * @param dateTime       格式化时间字符串
     * @param dateTimeFormat 时间格式
     * @return 毫秒数
     * @throws ParseException
     */
    public static long getMS(String dateTime, String dateTimeFormat) throws ParseException {
        return getMS(dateTime, dateTimeFormat, null);
    }

    public static long getMS(String dateTime, String dateTimeFormat, String timeZone) throws ParseException {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateTimeFormat);
        TimeZone tz = TextUtils.isEmpty(timeZone) ? TimeZone.getDefault() : TimeZone.getTimeZone(timeZone);
        simpleDateFormat.setTimeZone(tz);
        c.setTime(simpleDateFormat.parse(dateTime));
        return c.getTimeInMillis();
    }

    /**
     * 将毫秒数转化为格式化时间
     *
     * @param msTime         毫秒
     * @param dateTimeFormat 时间格式
     * @return 格式化时间
     */
    public static String getDateFormatTime(String msTime, String dateTimeFormat) {
        return getDateFormatTime(msTime, dateTimeFormat, null);
    }

    public static String getDateFormatTime(String msTime, String dateTimeFormat, String timeZone) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
        TimeZone tz = TextUtils.isEmpty(timeZone) ? TimeZone.getDefault() : TimeZone.getTimeZone(timeZone);
        sdf.setTimeZone(tz);
        return sdf.format(Long.parseLong(msTime));
    }

    /**
     * 转换时间格式
     *
     * @param dateTime     格式化时间字符串
     * @param originFormat 源时间格式
     * @param newFormat    新时间格式
     * @return
     */
    public static String changeFormat(String dateTime, String originFormat, String newFormat) {
        try {
            return getDateFormatTime(getMS(dateTime, originFormat) + "", newFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateTime;
        }
    }

    public static String changeFormat(String dateTime, String originFormat, String newFormat, String oldTimeZone, String newTimeZone) {
        try {
            return getDateFormatTime(getMS(dateTime, originFormat, oldTimeZone) + "", newFormat, newTimeZone);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateTime;
        }
    }

    public static void main(String[] args) {
        try {
/**
 * 将字符串数据转化为毫秒数
 */
            String dateTime = "2012-06-07 09:42:00";

            Calendar c = Calendar.getInstance();

            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateTime));

            System.out.println("时间转化后的毫秒数为：" + c.getTimeInMillis());
/**
 * 将毫秒数转化为时间
 */
            String sstime = "1339033320000";

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            System.out.println("毫秒数转化后的时间为：" + sdf.format(Long.parseLong(sstime)));
        } catch (java.text.ParseException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
