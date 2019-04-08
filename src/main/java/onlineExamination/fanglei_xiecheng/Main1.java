package onlineExamination.fanglei_xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        m++;
        n++;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[j] = dp[j] + dp[j-1];
            }
        }

        System.out.println(dp[n-1]);
    }
}
