package oj.leetcode;

import java.util.Arrays;

public class MinMeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        int[] startList = Arrays.stream(intervals).mapToInt(interval -> interval[0]).sorted().toArray();
        int[] endList = Arrays.stream(intervals).mapToInt(interval -> interval[1]).sorted().toArray();
        int length = intervals.length;
        int count = 0;
        int i = 0, j = 0;
        int res = 0;
        while (i < length && j < length) {
            if (startList[i] < endList[j]) {
                System.out.println("start:" + startList[i]);
                count++;
                i++;
            } else if (startList[i] > endList[j]) {

                System.out.println("end:" + endList[j]);
                count--;
                j++;
            } else {
                i++;
                j++;
            }
            res = Math.max(res, count);

            System.out.println(res);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{0,30},{5,10},{15,20}};
        new MinMeetingRoom().minMeetingRooms(array);
    }
}
