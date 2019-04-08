package onlineExamination.meililianhe;

import java.util.Scanner;

public class Main6182 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int m = (int)Math.sqrt(Math.sqrt(n));

        if (Math.pow(m, 4) == n) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

    }
}
