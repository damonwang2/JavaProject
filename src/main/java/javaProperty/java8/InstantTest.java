package javaProperty.java8;

import java.time.Instant;

public class InstantTest {
    public static void main(String[] args) {
        // 当前时间
        Instant instant1 = Instant.now();
        // 指定毫秒时间戳
        Instant instant2 = Instant.ofEpochMilli(1585497442630L);
        // 指定秒级时间戳和纳秒，纳秒不传默认为0。注意第二个参数的单位是纳秒，这里用 毫秒 * 100^6
        Instant instant3 = Instant.ofEpochSecond(1585497442, 630 * 1000_000);

        System.out.println(instant1);
        System.out.println(instant2.equals(instant3));
    }
}
