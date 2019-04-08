package onlineExamination.toutiao208_9;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n > 4) {
            System.out.println(0);
            return;
        }

        byte[] nums = new byte[n];

        for (byte i = 0; i < n; i++) {
            int num = in.nextInt();
            if (num > Byte.MAX_VALUE) {
                num -= 256;
            }
            nums[i] = (byte) num;
        }

        // 一个字符，并且最高位为0
        if (n == 1) {
            byte num1 = -128;
            if ((nums[0] & num1) == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return;
        }

        for (int i = n - 1; i > 0; i--) {
            if (nums[i] >= -64) {
                System.out.println(0);
                return;
            }
        }



        System.out.println(1);
    }
}
