package oj.leetcode;

import java.util.*;

public class CombinationSum2 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> used = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(new CombinationSum2().combinationSum2(nums, 30));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 排序是为了后面的used有序，进而判断重复
        // 如果无序则难以判断重复
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        int retainCount = 0;
        for (int num : candidates) {
            int count = countMap.getOrDefault(num, 0);
            if (num * (count + 1) <= target) {
                countMap.put(num, count+1);
                retainCount++;
            }
        }
        int[] candidatesNew = new int[retainCount];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                candidatesNew[index++] = entry.getKey();
            }
        }

        Arrays.sort(candidatesNew);
        // 从第0个开始和为target，转为第0个开始的任意一个i加入，target-candidate[i]
        backtracking(0, target, candidatesNew);
        return res;
    }

    //used数组为已经选过的，对于从pos开始剩下的数中，目标要为target
    public void backtracking(int pos, int target, int[] candidates){
        if(target < 0) {
            return;
        }

        if (target == 0 && !res.contains(used)) {
            res.add(new ArrayList<>(used));
            return;
        }
        //下一个选到的数为i，不是对每一个数采取选不选
        for(int i = pos; i < candidates.length; i++) {
            // 回溯剪枝
            used.add(candidates[i]);
            //这里的元素不可以重复取，所以是i+1
            backtracking(i + 1, target-candidates[i], candidates);
            used.remove(used.size() - 1);
        }
    }
}
