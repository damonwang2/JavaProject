package oj.leetcode;

import java.util.Arrays;

public class TriangleNumber {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            for (int i = 0, j = k - 1; i < j;) {
                if (nums[i] + nums[j] > nums[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
