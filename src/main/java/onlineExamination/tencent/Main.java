package onlineExamination.tencent;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static int mod = 1000000007;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] nums = new int[n];
        int[] maxs = new int[n];
        int[] mins = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        int res = 0;

        int k = in.nextInt();
        PriorityQueue<Number> maxHeap = new PriorityQueue<>(k, (num1, num2) -> num1.val - num2.val);
        PriorityQueue<Number> minHeap = new PriorityQueue<>(k, (num1, num2) -> num2.val - num1.val);

        for (int i = 0; i < n; i++) {
            // 找出最大的k个数，放在最小堆里面
            if (nums[i] > 0) {
                if (minHeap.size() < k) {
                    minHeap.add(new Number(i, nums[i]));
                } else if (nums[i] > minHeap.peek().val){
                    minHeap.remove(minHeap.peek());
                    minHeap.add(new Number(i, nums[i]));
                }

            } else if (nums[i] < 0) {
                // 最小的k个数放在最大堆
                if (maxHeap.size() < k) {
                    maxHeap.add(new Number(i, nums[i]));
                } else if (nums[i] < maxHeap.peek().val){
                    maxHeap.remove(maxHeap.peek());
                    maxHeap.add(new Number(i, nums[i]));
                }
            }
        }

        // 将最大的k个正数改为负数
        for (Number number : minHeap) {
            int i = number.index;
            nums[i] = -nums[i];
        }

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                maxs[i] = nums[i];
                mins[i] = nums[i];
            } else {
                maxs[i] = Math.max(nums[i], nums[i] + maxs[i-1]);
                mins[i] = Math.min(nums[i], nums[i] + mins[i-1]);
            }

            res = Math.max(res, maxs[i]);
            res = Math.max(res, -mins[i]);
        }

        // 将其改回来
        for (Number number : minHeap) {
            int i = number.index;
            nums[i] = -nums[i];
        }

        // 将最小的k个负数改为正数
        for (Number number : maxHeap) {
            int i = number.index;
            nums[i] = -nums[i];
        }

        Arrays.fill(maxs, 0);
        Arrays.fill(mins, 0);
        for (int i = 0; i < n; i++) {

            if (i == 0) {
                maxs[i] = nums[i];
                mins[i] = nums[i];
            } else {
                maxs[i] = Math.max(nums[i], nums[i] + maxs[i-1]);
                mins[i] = Math.min(nums[i], nums[i] + mins[i-1]);
            }

            res = Math.max(res, maxs[i]);
            res = Math.max(res, -mins[i]);
        }

        System.out.println(res);
    }
}

class Number {
    int index;
    int val;

    public Number(int index, int val) {
        this.index = index;
        this.val = val;
    }
}
