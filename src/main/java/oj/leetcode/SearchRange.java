package oj.leetcode;

public class SearchRange {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new SearchRange().getFirst(nums, 1));
        System.out.println(new SearchRange().getLast(nums, 1));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res1 = {-1, -1};
        if (nums.length <= 0) {
            return res1;
        }

        int first = getFirst(nums, target);
        int last = getLast(nums, target);

        if (nums[first] != target || nums[last] != target) {
            return res1;
        } else {
            int[] res = {first, last};
            return res;
        }
    }

    public int getFirst(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // 找到第一个大于等于target的数
        while (low < high) {
            int mid = (low + high) / 2;

            if (target <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int getLast(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        // 找到第一个大于target的数
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // low-1则是第一个小于等于target的数
        return low - 1;
    }
}
