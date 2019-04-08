package oj.leetcode;

import java.util.Arrays;

public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        uniquePathsWithObstacles(obstacleGrid);
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        boolean obstacleBefore = false;

        for (int j = 0; j < n; j++) {
            // 前面有障碍或者当前障碍
            if (obstacleBefore || obstacleGrid[0][j] == 1) {
                obstacleBefore = true;
                dp[j] = 0;
            }
            System.out.println(dp[j]);
        }

        for (int i = 1; i < m; i++) {

            if (obstacleGrid[i][0] == 1) {
                dp[0] = 0;
            }

            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else {
                    dp[j] += dp[j-1];
                }
            }
        }

        return dp[n-1];
    }
}
