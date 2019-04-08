package onlineExamination.netease2018_9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();

        int countB = 0;
        int countW = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'b') {
                countB++;
            } else {
                countW++;
            }
        }

        if (countB == countW) {
            System.out.println(str.length());
        } else {
            System.out.println(2 * Math.min(countB, countW) + 1);
        }
    }
}
