package oj.leetcode;

public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1.length <= nums2.length
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int iMin = 0, iMax = m;
        int half = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = half - i;

            if (i < m && nums2[j-1] > nums1[i]) {
                iMin = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxOfLeft, minOfRight;

                if (i == 0) {
                    maxOfLeft = nums2[j-1];
                } else if (j == 0) {
                    maxOfLeft = nums1[i-1];
                } else {
                    maxOfLeft = Math.max(nums1[i-1], nums2[j-1]);
                }

                if ((m + n) % 2 == 1) {
                    return maxOfLeft;
                }

                if (i == m) {
                    minOfRight = nums2[j];
                } else if (j == n) {
                    minOfRight = nums1[i];
                } else {
                    minOfRight = Math.min(nums1[i], nums2[j]);
                }

                return (maxOfLeft + minOfRight) / 2.0;
            }
        }

        return 0;
    }
}
