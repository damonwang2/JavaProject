package oj.leetcode;

public class Search {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low=0,high=n-1;

        // 找出最小值所在的index
        while(low < high){
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        int rot = low;
        low = 0;
        high = n-1;
        // 相当于low，high进行了一个旋转
        // low，high的旋转，最终反映到的是nums[mid]和target的比较上
        while(low <= high) {
            int mid = (low + high) / 2;
            int realMid = (mid + rot) % n;
            if(nums[realMid] == target) {
                return realMid;
            }

            if(nums[realMid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
