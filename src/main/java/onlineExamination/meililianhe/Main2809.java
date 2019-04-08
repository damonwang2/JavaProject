package onlineExamination.meililianhe;

import java.util.Scanner;

public class Main2809 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String day = in.next();

        int[] lastDays = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String monthStr = day.substring(0, 2);
        int month = Integer.parseInt(monthStr);

        System.out.println(monthStr + lastDays[month]);
    }
}
