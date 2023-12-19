import java.util.List;

public class FindLoop {

    /**
     *
     * @param listNode
     * @return 返回环入口；无环返回null
     */
    public ListNode find(ListNode listNode) {
        ListNode head = listNode;
        ListNode fast = listNode;
        ListNode low = listNode;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        // 无环
        if (fast == null || fast.next == null) {
            return null;
        }
        while (head != fast) {
            head = head.next;
            fast = fast.next;
        }
        return fast;
    }
// 非环部分m个，环部分n个，2k步，和k步 2k-k / n 为整数，
//123456
//   987

    private class ListNode {
        public ListNode next;
    }
}

