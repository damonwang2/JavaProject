package oj.leetcode;

public class OptimalDivision {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        StringBuilder res = new StringBuilder();
        res.append(nums[0]);

        if (n == 1) {
            return res.toString();
        }

        res.append("/");
        if (n == 2) {
            res.append(nums[1]);
            return res.toString();
        }

        // 已经有num/()
        res.append("(");
        for (int i = 1; i < n - 1; i++) {
            res.append(nums[i]).append("/");
        }
        res.append(nums[n-1]).append(")");

        return res.toString();
    }
}
