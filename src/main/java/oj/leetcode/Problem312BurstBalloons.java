package oj.leetcode;

public class Problem312BurstBalloons {
    public static void main(String[] args) {

    }

    public static int maxCoins(int[] nums) {
        //初始化
        int[] newNums = new int[nums.length+2];
        int n = 1;
        for(int num : nums){
            newNums[n++] = num;
        }
        newNums[0] = newNums[n++] = 1;

        int[][] dp = new int[n][n];

        for(int k = 2; k < n; k++){
            for(int left = 0; left < n - k; left++){
                int right = left + k;
                for(int i = left+1; i < right; i++){
                    //left和right是边界，不能burst
                    dp[left][right] = Math.max(dp[left][right],
                            newNums[left] * newNums[i]*newNums[right]+dp[left][i]+dp[i][right]);
                }
            }
        }

        return dp[0][n-1];
    }
}
