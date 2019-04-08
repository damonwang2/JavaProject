package oj.leetcode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        threeSum(nums);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }

        // 排序
        Arrays.sort(nums);
//        System.out.println(new ArrayList<>(Arrays.asList(nums)));
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            // 和前一個數一樣
            if (i > 0 && nums[i] > nums[i-1]) {
                continue;
            }

            int begin = i + 1, end = nums.length - 1;
            while (begin < end) {
                int sum = nums[i] + nums[begin] + nums[end];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[begin]);
                    list.add(nums[end]);
                    res.add(list);
                    while(begin < end  &&  nums[begin] == nums[begin+1])
                        begin++;
                    while(begin < end  &&  nums[end] == nums[end-1])
                        end--;
                    System.out.println(list);

                    begin++;
                    end--;

                } else if (sum > 0) {
                    end--;
                } else {
                    begin++;
                }
            }
        }

        return res;
    }
}
