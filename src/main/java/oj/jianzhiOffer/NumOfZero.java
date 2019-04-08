package oj.jianzhiOffer;

import java.util.Scanner;

public class NumOfZero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }

        System.out.println(count);
    }
}
