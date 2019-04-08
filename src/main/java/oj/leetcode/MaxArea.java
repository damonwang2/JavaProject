package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MaxArea {

    public static void main(String[] args) {
        int[] a = {1,3,2,5,25,24,5};
        int res = maxArea(a);
        System.out.println(res);
    }

    public static int maxArea(int[] height) {
        List<Integer> prepare = new ArrayList<>();

        prepare.add(0);
        prepare.add(1);

        int res = Math.min(height[1], height[0]);

        for (int i = 2; i < height.length; i++) {
            for (int j : prepare) {
                res = Math.max(res, (i - j) * Math.min(height[i], height[j]));
            }

            if (height[i] > height[prepare.get(prepare.size() - 1)]) {
                prepare.add(i);
            }
        }

        return res;
    }
}
