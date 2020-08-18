package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pojun
 * @date 2020/8/14
 */
public class IntervalInteraction {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int lengthA = A.length;
        int lengthB = B.length;

        List<int[]> intervalList = new ArrayList<>();
        // 每个区间列表都是成对不相交
        for (int i = 0, j = 0; i < lengthA && j < lengthB;) {
            int[] intervalA = A[i];
            int[] intervalB = B[j];

            int[] intersection = getIntersection(intervalA, intervalB);
            if (intersection != null) {
                intervalList.add(intersection);
            }
            // 保留end大的
            if (intervalA[1] < intervalB[1]) {
                i++;
            } else if (intervalA[1] > intervalB[1]) {
                j++;
            } else {
                i++;
                j++;
            }

        }
        return intervalList.toArray(new int[intervalList.size()][2]);

        // 放在一起排序，然后比较
    }

    public int[] getIntersection(int[] intervalA, int[] intervalB) {
        if (intervalA[0] > intervalB[1] || intervalA[1] < intervalB[0]) {
            return null;
        }

        return new int[]{Math.max(intervalA[0], intervalB[0]), Math.min(intervalA[1], intervalB[1])};
    }

    public static void main(String[] args) {
        //new IntervalInteraction().getIntersection()
    }
}