package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> permute(int[] nums) {
        permuteRecursive(nums, 0);
        return res;
    }

    public void permuteRecursive(int[] nums, int begin) {
        if (begin >= nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }

            res.add(list);
        }

        for (int i = begin; i < nums.length; i++) {
            swap(nums, begin, i);
            permuteRecursive(nums, begin + 1);
            swap(nums, begin, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
