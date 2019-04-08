package oj.leetcode;

public class SingleNonDuplicate {
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] == nums[mid - 1]) {
                // 该数在前半部分，low-mid共有2n+1个数字
                if ((mid - low) % 2 == 0) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                // 在后半部分
                if ((mid - low) % 2 == 0) {
                    low = mid + 2;
                } else {
                    // 前半部分
                    high = mid - 1;
                }
            } else {
                return mid;
            }
        }

        return low;
    }
}
