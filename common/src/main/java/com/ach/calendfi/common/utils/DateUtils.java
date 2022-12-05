package com.ach.calendfi.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @className: DateUtils
 * @description: DateUtils
 * @date: 2020/8/18
 * @author: cakin
 */
public class DateUtils {
    private static final long ONE_MINUTE = 60;
    private static final long ONE_HOUR = 3600;
    private static final long ONE_DAY = 86400;
    private static final long ONE_MONTH = 2592000;
    private static final long ONE_YEAR = 31104000;

    public static Calendar calendar = Calendar.getInstance();

    /**
     * @return yyyy-mm-dd
     */
    public static String getDate() {
        return getYear() + "-" + getMonth() + "-" + getDay();
    }

    /**
     * @param format
     * @return yyyy-MM-dd HH:mm
     * MM-dd HH:mm 2012-12-25
     */
    public static String getDate(String format) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        return simple.format(calendar.getTime());
    }

    /**
     * @return yyyy-MM-dd HH:mm
     * 2012-12-29 23:47
     */
    public static String getDateAndMinute() {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simple.format(calendar.getTime());
    }

    /**
     * @return yyyy-MM-dd HH:mm:ss
     * 2012-12-29 23:47:36
     */
    public static String getFullDate() {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simple.format(calendar.getTime());
    }

    public static String getYear() {
        return calendar.get(Calendar.YEAR) + "";
    }

    public static String getMonth() {
        int month = calendar.get(Calendar.MONTH) + 1;
        return month + "";
    }

    public static String getDay() {
        return calendar.get(Calendar.DATE) + "";
    }

    public static String get24Hour() {
        return calendar.get(Calendar.HOUR_OF_DAY) + "";
    }

    public static String getMinute() {
        return calendar.get(Calendar.MINUTE) + "";
    }

    public static String getSecond() {
        return calendar.get(Calendar.SECOND) + "";
    }

    public static long dateToStamp(String time) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }

    public static long dateToStamp(Date date) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        return date.getTime();
    }

    public static String getyyyymmdd(String time) {
        long times = Long.parseLong(time);
        Date date = new Date(times);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(date);
    }

    public static String CalculateTime(long time) {
        long nowTime = System.currentTimeMillis(); // Get the current time in milliseconds
        String msg = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// Specify time format
        long reset = time; // Get the milliseconds of the specified time
        long dateDiff = nowTime - reset;
        if (dateDiff < 0) {
            msg = "The time entered is incorrect";
        } else {
            long dateTemp1 = dateDiff / 1000; // second
            long dateTemp2 = dateTemp1 / 60; // minute
            long dateTemp3 = dateTemp2 / 60; // Hour
            long dateTemp4 = dateTemp3 / 24; // Days
            long dateTemp5 = dateTemp4 / 30; // Months
            long dateTemp6 = dateTemp5 / 12; // Years
            if (dateTemp6 > 0) {
                msg = dateTemp6 + " year ago";
            } else if (dateTemp5 > 0) {
                msg = dateTemp5 + " month ago";
            } else if (dateTemp4 > 0) {
                msg = dateTemp4 + " day ago";
            } else if (dateTemp3 > 0) {
                msg = dateTemp3 + " hour ago";
            } else if (dateTemp2 > 0) {
                msg = dateTemp2 + " minute ago";
            } else if (dateTemp1 > 0) {
                msg = "just";
            }
        }
        return msg;
    }
}