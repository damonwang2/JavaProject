package onlineExamination.meituan2018_9;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int t = in.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        // 定义左右区间，闭区间
        int l = 0, r = k - 1;
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int i = 0; i <= r; i++) {
            int num = nums[i];
            if (numCounts.containsKey(num)) {
                numCounts.put(num, numCounts.get(num) + 1);
            } else {
                numCounts.put(num, 1);
            }
        }

        int count = 0;
        while (r < n) {
            if (check(numCounts, t)) {
                count++;
            }

            // 删除左边的，增加右边的
            numCounts.put(nums[l], numCounts.get(nums[l]) - 1);
            if (r < n - 1) {
                int num = nums[r];
                if (numCounts.containsKey(num)) {
                    numCounts.put(num, numCounts.get(num) + 1);
                } else {
                    numCounts.put(num, 1);
                }
            }
            l++;
            r++;
        }

        System.out.println(count);

    }

    public static boolean check(Map<Integer, Integer> map, int t) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= t) {
                return true;
            }
        }
        return false;
    }
}