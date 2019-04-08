package dataStructureAndAlgorithm;

import java.util.Arrays;

public class Jump {

    public static void main(String[] args) {

    }

    public int jump(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        // Integer.MAX_VALUE表示不可以到达，正数表示能够的最短次数
        Arrays.fill(counts, Integer.MAX_VALUE);
        counts[0] = 0;

        for (int i = 0; i < n; i++) {

            // 优化：如果当前的数小于前一个，其可到达的点是前驱结点可到达点的自己
            if (i != 0 && nums[i] < nums[i-1]) {
                continue;
            }

            if (counts[i] != Integer.MAX_VALUE) {
                // 将后面可以到达的点设置为true
                for (int j = 1; j <= nums[i] && (i + j) < n; j++) {
                    counts[i+j] = Math.min(counts[i+j], counts[i] + 1);
                }
            }
        }

        return counts[n-1];
    }
}
