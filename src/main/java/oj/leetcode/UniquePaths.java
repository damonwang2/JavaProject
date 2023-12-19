package oj.leetcode;

public class UniquePaths {
    public static void main(String[] args) {
        new UniquePaths().uniquePaths(59, 5);
    }
    public int uniquePaths(int m, int n) {
        // int[] dp = new int[n];
        // // 第0行肯定全是1，没必要遍历
        // Arrays.fill(dp, 1);

        // for(int i = 1; i < m; i++){
        //     for(int j = 1; j < n; j++){
        //         dp[j] = dp[j] + dp[j-1];
        //     }
        // }
        // return dp[n-1];
        long ans = 1;
        int sum = m + n;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * (sum-y-1)/ y;
            System.out.println(ans);
        }
        return (int) ans;
    }
}
