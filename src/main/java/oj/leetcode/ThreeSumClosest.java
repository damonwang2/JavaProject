package oj.leetcode;

import java.util.Arrays;

public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] a = {-1, 2, 1, -4};
        int res = threeSumClosest(a, 1);
        System.out.println(res);
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gapAbs = Integer.MAX_VALUE;
        int res = 0;

        // i为第一个数，然后从剩下的数字选两个数
        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int gap = sum - target;

                if (Math.abs(gap) < gapAbs) {
                    gapAbs = Math.abs(gap);
                    res = sum;
                }

                if (gap == 0) {
                    return gap;
                } else if (gap > 0) {
                    end--;
                } else {
                    start++;
                }


            }
        }

        return res;
    }
}
