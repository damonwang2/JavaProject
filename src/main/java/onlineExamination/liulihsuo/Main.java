package onlineExamination.liulihsuo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        long[] dp = new long[n+1];
        dp[0] = 1;
        int[] coins = {1, 5, 10, 20, 50};

        for (int i = 1; i <= n; i++) {
            for (int coin : coins) {
                // 剩下的钱
                int m = i - coin;
                if (m >= 0) {
                    dp[i] += dp[m];
                }
            }
        }

        System.out.println(dp[n]);

    }
}
