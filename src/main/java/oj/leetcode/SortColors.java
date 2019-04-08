package oj.leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int index0 = 0, index2 = n-1;

        for (int i = 0; i <= index2; i++) {
            // 交换
            if (nums[i] == 0) {
                swap(nums, i, index0);
                index0++;
            } else if (nums[i] == 2) {
                swap(nums, i, index2);
                index2--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
