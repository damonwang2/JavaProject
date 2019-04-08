package dataStructureAndAlgorithm;

import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int length = triangle.size();
        // 最长的数组
        List<Integer> list = triangle.get(length-1);

        int n = list.size();
        int[] res = new int[n];
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
            max = Math.min(max, res[i]);
        }

        for (int i = length - 2; i >= 0; i--) {
            list = triangle.get(i);
            int curMax = Integer.MAX_VALUE;
            for (int j = 0; j < list.size(); j++) {
                res[i] = Math.min(res[i], res[i+1]) + list.get(j);
                curMax = Math.min(curMax, res[i]);
            }
            max = curMax;
        }

        return max;
    }
}
