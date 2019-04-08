package javaProperty.java8;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by pojun on 2019/1/13.
 */
public class DateTest {
    public static void main(String[] args) {
//        testZonedDateTime();
//        testLocalDateTime();
        testInstant();
    }

    public static void testLocalDateTime() {
        LocalDate localDate = LocalDate.now();

        LocalDateTime currentTime = LocalDateTime.now();

        Month month = currentTime.getMonth();

        System.out.println(month.getValue());

        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();

        System.out.println(localTime);

        month = Month.valueOf("MAY");
        System.out.println(month);

    }

    public static void testZonedDateTime() {

        // 解析字符串中的时间
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }

    public static void testInstant() {
        Instant timestamp = Instant.now();
        System.out.println("What is value of this instant " + timestamp);

        String dayWithoutFormat = "20140116";
        LocalDate formatted = LocalDate.parse(dayWithoutFormat, DateTimeFormatter.BASIC_ISO_DATE);

        System.out.printf("Date generated from String %s is %s %n", dayWithoutFormat, formatted);

        System.out.println(timestamp.getNano());
    }
}
