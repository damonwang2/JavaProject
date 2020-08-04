package test;

import java.util.Scanner;

/**
 * Created by pojun on 2019/1/7.
 */
public class CalWorkingHour {
    public static void main(String[] args) throws Exception {
        int day = 0;
        double sumOfHour = 0;
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String timeStr = in.nextLine();
            // 时间行
            if (!timeStr.contains(":")) {
                continue;
            }

            double start = getTime(timeStr);
            double end = getTime(in.nextLine());

            sumOfHour += (end - start);
            day++;
        }

        System.out.println("工作天数:" + day);
        System.out.println("工作时长:" + sumOfHour);
        System.out.println("平均每天时长:" + sumOfHour / day);
    }

    private static double getTime(String timeStr) {
        String[] strings = timeStr.split(":");
        double hour = Double.valueOf(strings[0]);
        double minute = Double.valueOf(strings[1]);

        if (hour < 6) {
            hour += 24;
        }

        return (hour + minute / 60);
    }
}
