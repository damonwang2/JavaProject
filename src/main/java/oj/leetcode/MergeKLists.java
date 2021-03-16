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
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(listNode -> listNode.val));
        for (ListNode listNode : lists) {
            priorityQueue.add(listNode);
        }
        ListNode head = new ListNode(0);
        ListNode result = head;

        while (!priorityQueue.isEmpty()) {
            ListNode minNode = priorityQueue.poll();
            head.next = minNode;
            head = head.next;
            if (minNode.next != null) {
                priorityQueue.add(minNode.next);
            }
        }
        return result.next;
    }
}