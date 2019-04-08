package oj.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindMaxLength {
    public int findMaxLength(int[] nums) {
        // 相同数量的0 1变换为-1 1
        // 只要数量相同，其和为0
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        // 0->index(包含)的sum作为key，index作为value
        Map<Integer, Integer> sumToIndex = new HashMap<>();

        // index = -1表示没有元素，和为0
        sumToIndex.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }

        return max;
    }
}
