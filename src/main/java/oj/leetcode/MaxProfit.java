package oj.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author pojun
 * @date 2020/7/4
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {

        int[] diffValues = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            diffValues[i] = diff;
        }

        List<Integer> list = new ArrayList<>();
        int profitCount = 0;
        // 从diffValues找出两段连续的大于0的数值
        for (int i = 0; i < diffValues.length;) {

            int profit = 0;
            while (i < diffValues.length && diffValues[i] >= 0) {
                profit += diffValues[i];
                i++;
            }

            if (profit > 0) {
                profitCount++;
                list.add(profit);
            }

            profit = 0;
            while (i < diffValues.length && diffValues[i] <= 0) {
                profit += diffValues[i];
                i++;
            }
            if (profit < 0) {
                list.add(profit);
            }
        }

        int res = 0;
        if (profitCount <= 2) {
            for (Integer integer : list) {
                if (integer > 0) {
                    res += integer;
                }
            }
            return res;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // merge value
        for (int i = 0; i < list.size(); i++) {
            // 左右两个数都大于中间的数
            int cur = list.get(i);
            if (cur < 0) {
                continue;
            }
            while (i < list.size() -2 && profitCount > 2 && cur >= Math.abs(list.get(i+1)) && list.get(i+2) >= Math.abs(list.get(i+1))) {
                cur += (list.get(i+2) + list.get(i+1));
                i+=2;
                profitCount--;
            }
            priorityQueue.add(cur);

            if (priorityQueue.size() > 2) {
                priorityQueue.poll();
            }
        }



        while (!priorityQueue.isEmpty()) {
            res += priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{8,6,4,3,3,2,3,5,8,3,8,2,6};
        System.out.println(new MaxProfit().maxProfit(a));;
    }

}