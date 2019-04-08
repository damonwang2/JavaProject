package oj.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    PriorityQueue<Integer> heap;
    int num;

    // 找到第k大，维持一个元素个数为k的最小堆
    public KthLargest(int k, int[] nums) {
        heap = new PriorityQueue<>(k);
        num = k;

        for (int i = 0; i < k - 1; i++) {
            heap.add(nums[i]);
        }

        // 新增一个，减少一个
        for (int i = k; i < nums.length; i++) {
            heap.add(nums[i]);
            if (heap.size() > k) {
                heap.remove(heap.peek());
            }
        }
    }

    public int add(int val) {
        heap.add(val);
        int res = heap.peek();

        if (heap.size() > num) {
            heap.remove(res);
        }

        return res;
    }
}
