package br.com.skywalker.plugboleto.util;

import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtil {
    public static final String DATE_TECNOSPEED_PATTERN = "dd/MM/yyyy";
    public static final String DATE_HTML_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_TECNOSPEED_PATTERN = "dd/MM/yyyy HH:mm:ss";
    public static final String DATE_TIME_OFFSET_ISO_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"; // 2020-03-06T18:51:27.000Z

    public static LocalDateTime fromStringToLocalDateTime(String date){
        if(date.length() == 10)
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DATE_TECNOSPEED_PATTERN));
        else if(date.length() == 19)
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_TECNOSPEED_PATTERN));
        else if(date.length() == 24)
            return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(DateUtil.DATE_TIME_OFFSET_ISO_FORMAT));

        return null;
    }
}
