package oj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }

    public void backtrack(int[] nums, ArrayList<Integer> tempList, int start) {
        res.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            // i已经被加入了
            backtrack(nums, tempList, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

}

