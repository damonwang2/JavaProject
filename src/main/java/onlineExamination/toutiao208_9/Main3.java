package onlineExamination.toutiao208_9;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        int length = s.length();
        int sum = back(length, 3);

        System.out.println(sum);
    }

    public static int back(int length, int pointNum) {
        if (length == pointNum + 1) {
            return 1;
        }

        int sum = 0;

        for (int i = 1; i <= length - pointNum; i++) {
            sum += back(length - i, pointNum - 1);
        }
        return sum;
    }
}
