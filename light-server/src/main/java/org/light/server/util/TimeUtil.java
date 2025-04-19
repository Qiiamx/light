package org.light.server.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
    private static final DateTimeFormatter dateTimeFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter dateFmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static String format(LocalDateTime localDateTime) {
        return TimeUtil.format(localDateTime, dateTimeFmt);
    }

    public static String format(LocalDateTime localDateTime, DateTimeFormatter fmt) {
        return localDateTime.format(fmt);
    }

    public static LocalDateTime parseDateTime(String date) {
        return TimeUtil.parse(date, dateTimeFmt);
    }

    public static LocalDateTime parseDate(String date) {
        return TimeUtil.parse(date, dateFmt);
    }

    public static LocalDateTime parse(String date, DateTimeFormatter fmt) {
        return LocalDateTime.parse(date, fmt);
    }

    public static String[] between(String reportTime) {
        if(reportTime == null || reportTime.isBlank()){
            return null;
        }else{
            String base = reportTime.split(" ")[0];
            return new String[]{base+" 00:00:00", base+" 23:59:59"};
        }
    }
}
