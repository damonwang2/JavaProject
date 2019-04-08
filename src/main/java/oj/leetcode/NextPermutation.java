package oj.leetcode;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int i = n - 1;
        // 从右往左找
        while (i > 0 && nums[i-1] >= nums[i]) {
            i--;
        }

        if (i == 0) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 将nums[i-1]和第一个比nums[i-1]大的数进行交换
        int j = n - 1;
        while (j >= i) {
            if (nums[j] > nums[i-1]) {
                break;
            }
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i, n-1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i-1];
        nums[i-1] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            swap(nums, i, start + end - i);
        }
    }
}
