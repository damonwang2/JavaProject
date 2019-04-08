package oj.leetcode;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // curSum会根据情况截取数组的一部分
        int curSum = 0;
        // sum贯穿整个数组
        int sum = 0;
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            int left = gas[i] - cost[i];
            curSum += left;
            sum += left;
            
            if (curSum <= 0) {
                curSum = 0;
                res = i + 1;
            }
        }

        // sum < 0 表示gas的和小于cost的和
        if (sum < 0) {
            return -1;
        }

        return res % n;
    }
}
