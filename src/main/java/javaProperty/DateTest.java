package javaProperty;

import org.apache.commons.net.ntp.TimeStamp;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

public class DateTest {
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);

        LocalDate localDate2 = LocalDate.of(2020, 2, 3);

        System.out.println(localDate2.with(firstDayOfMonth()));

        LocalDateTime now = new Timestamp(1585418912000L).toLocalDateTime();

        System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

    }
}
