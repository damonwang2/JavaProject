package javaProperty.java8;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterTest {
    public static void main(String[] args) {
        // 自带的日期时间格式化器
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        // 自定义格式化器
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        LocalDateTime localDateTime = LocalDateTime.now();

        String timeStr1 = localDateTime.format(dateTimeFormatter1);
        String timeStr2 = localDateTime.format(dateTimeFormatter2);
        System.out.println(timeStr1);
        System.out.println(timeStr2);

        System.out.println(LocalDateTime.parse(timeStr1, dateTimeFormatter1).equals(
                LocalDateTime.parse(timeStr2, dateTimeFormatter2)));

        // world time
        DateTimeFormatter dateTimeFormatter3 = DateTimeFormatter.ISO_INSTANT;
        System.out.println(localDateTime.format(dateTimeFormatter3));
        System.out.println(ZonedDateTime.now());
    }
}
