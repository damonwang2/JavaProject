package oj.leetcode;

public class WiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int[] differences = new int[n-1];
        boolean[] dp = new boolean[n-1];
        dp[0] = true;
        int res = 1;
        int start = -1;

        for (int i = 0; i < n - 1; i++) {
            differences[i] = nums[i] - nums[i+1];
        }

        for (int i = 1; i < n - 1; i++) {

            // 2.当前数字和前一个数字异号
            if ((differences[i - 1] < 0 && differences[i] > 0) || (differences[i - 1] > 0 && differences[i] < 0)) {
                res = Math.max(res, i - start + 1);
            } else {
                res = 1;
                start = i;
            }
        }

        // 因为nums到differences相差一个数字
        return res + 1;
    }
}
