package oj.leetcode;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }

        int newLength = 1;
        int i = 1;

        while (i < n) {
            int num = nums[i];
            while (nums[i] == nums[i-1]) {
                i++;
            }

            nums[newLength++] = num;
            i++;
        }

        return newLength;
    }
}
