package onlineExamination.netease2018_9;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();

            System.out.println(0 + " " + Math.max(0, Math.min(n - k, k - 1)));
        }
    }
}
