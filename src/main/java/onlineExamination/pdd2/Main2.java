package onlineExamination.pdd2;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(get(nums));
    }

    private static int get(int[] nums) {
        // 纸箱的数量在[0, 10^9]之间，用数组记录数量不合适，用Map
        SortedMap<Integer, Integer> boxCount = new TreeMap<>();
        for (int num: nums) {
            boxCount.putIfAbsent(num, 0);
            boxCount.put(num, boxCount.get(num) + 1);
        }

        // 遍历
        int count = 0;
        // 已包装的箱子
        int packaged = 0;
        // 如果已经装进去的数量达到了nums总数量，则推出
        while (packaged < nums.length) {

            // 从小到大装箱
            // 如果大小为boxSize的数量为0，表示箱子用完了，跳过装箱，找更到
            // 如果装进去了，数量减1
            // 每一次for循环表示一次从小到大装箱动作，count++
            for (Map.Entry<Integer, Integer> entry: boxCount.entrySet()) {
                Integer boxSize = entry.getKey();
                Integer boxNum = entry.getValue();

                if (boxNum == 0) {
                    continue;
                }

                boxCount.put(boxSize, boxNum - 1);
                packaged++;
            }

            count++;
        }

        return count;
    }
}
