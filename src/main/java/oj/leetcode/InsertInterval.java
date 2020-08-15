package oj.leetcode;

import java.util.*;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        // 新区间是否放置进答案
        for(int i = 0; i < intervals.length; i++) {
            // 毫无交集的部分，直接add
            if(newInterval[0] > intervals[i][1]){
                res.add(intervals[i]);
                continue;
            }

            // 和之后的数据没有交集
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                for(; i < intervals.length; i++)
                    res.add(intervals[i]);
                return res.toArray(new int[res.size()][2]);
            }
            // 合并有交集的部分
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);  //区间合并
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
        }
        res.add(newInterval);

        return res.toArray(new int[res.size()][2]);
    }
     public static class Interval {
         int start;
         int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
     }
}
