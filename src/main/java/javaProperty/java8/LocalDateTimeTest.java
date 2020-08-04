package javaProperty.java8;

import java.time.LocalDateTime;

public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 通过of()和now()创建LocalDateTime对象
        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 4, 1, 0, 0, 0);

        // 通过LocalDate和LocalTime的toString拼接而来的，通过T分隔
        // LocalTime的秒0为时则省略
        String dateTimeStr1 = localDateTime1.toString();
        System.out.println(dateTimeStr1);
        System.out.println(localDateTime2);

        // 解析格式化的日期，比SimpleDateFormat用起来简单多了
        // 解析后用equals判断为true
        LocalDateTime localDateTime3 = LocalDateTime.parse(dateTimeStr1);
        System.out.println(localDateTime3.equals(localDateTime1));
    }
}
