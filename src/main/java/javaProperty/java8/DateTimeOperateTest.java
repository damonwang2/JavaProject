package javaProperty.java8;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class DateTimeOperateTest {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime.plusWeeks(1));

        // LocalDateTime本身是一个没有时区的概念，可以认为只是记录了年月日时分秒这几个数字
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        // 获取timestamp
        System.out.println(instant.toEpochMilli());
    }
}
