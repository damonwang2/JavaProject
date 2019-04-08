package onlineExamination.alibaba2018_9;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 3 != 0) {
            System.out.println(0);
        } else {
            System.out.println(n / 3);
        }
    }
}