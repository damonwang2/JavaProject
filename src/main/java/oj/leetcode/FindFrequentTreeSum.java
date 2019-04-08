package oj.leetcode;

import java.util.*;

public class FindFrequentTreeSum {

    int maxCount = 0;
    Map<Integer, Integer> numCount = new HashMap<>();
    List<Integer> nums = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        helper(root);

        int[] res = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            res[i] = nums.get(i);
        }
        return res;
    }

    public int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }


        int val = helper(node.left) + helper(node.right) + node.val;
        int count = 1;
        if (numCount.containsKey(val)) {
            count += numCount.get(val);
        }
        numCount.put(val, count);

        if (count > maxCount) {
            nums.clear();
            nums.add(val);
        } else if (count == maxCount) {
            nums.add(val);
        }

        return val;

    }
}
