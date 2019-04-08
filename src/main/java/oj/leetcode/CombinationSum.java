package oj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> used = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //从第0个开始和为target，转为第0个开始的任意一个i加入，target-candidate[i]
        backtracking(0, target, candidates);
        return res;
    }

    //used数组为已经选过的，对于从pos开始剩下的数中，目标要为target
    void backtracking(int pos, int target, int[] candidates){
        if(target == 0){
            res.add(new ArrayList<>(used));
            return;
        }
        //下一个选到的数为i，不是对每一个数采取选不选
        for(int i = pos; i < candidates.length; i++){
            // 回溯剪枝
            if(target >= candidates[i]){
                used.add(candidates[i]);
                //这里的元素可以重复取，所以从i开始，不是i+1
                backtracking(i, target-candidates[i], candidates);
                used.remove(used.size() - 1);
            }
        }
    }
}
