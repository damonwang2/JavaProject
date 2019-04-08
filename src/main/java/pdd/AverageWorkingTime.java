package pdd;

import java.util.Scanner;

public class AverageWorkingTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        int sumHour = 0;
        // 局部变量必须初始化
        int sumMin = 0;
        while (in.hasNext()) {
            count++;
            String line = in.nextLine();
            String[] hourAndMin = line.split(":");
            int hour = Integer.parseInt(hourAndMin[0]);
            int min = Integer.parseInt(hourAndMin[1]);
            sumHour += hour;
            sumMin += min;
            if (hour == 0) {
                sumHour += 24;
            }
        }
        sumMin += (sumHour * 60);
        sumMin /= count;

        int averageHour = sumMin / 60;
        int averageMin = sumMin - averageHour * 60;

        System.out.println(averageHour + ":" + averageMin);
    }
}
