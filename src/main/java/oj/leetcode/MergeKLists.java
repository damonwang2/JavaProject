package oj.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

import javafx.util.Pair;

/**
 * @author pojun
 * @date 2020/6/18
 */
public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair<Integer, ListNode>> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(Pair::getKey));
        for (ListNode listNode : lists) {
            priorityQueue.add(new Pair<>(listNode.val, listNode));
        }
        ListNode head = new ListNode(0);
        ListNode result = head;

        while (!priorityQueue.isEmpty()) {
            Pair<Integer, ListNode> pair = priorityQueue.poll();
            ListNode minNode = pair.getValue();
            head.next = minNode;
            head.next = head.next.next;
            if (minNode.next != null) {
                priorityQueue.add(new Pair<>(minNode.next.val, minNode.next));
            }
        }
        return result.next;
    }
}