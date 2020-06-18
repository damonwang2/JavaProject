package oj.leetcode;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class PalindromLinkedLIst {
	
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		ListNode m1 = new ListNode(1) ;
		ListNode m2 = new ListNode(2) ;	m1.next = m2;
		ListNode m3 = new ListNode(3) ;m2.next = m3;
		ListNode m4 = new ListNode(4) ;m3.next = m4;
//		ListNode m5 = new ListNode(5) ;m4.next = m5;
					
	
		ListNode head = m1;
        int i = 0,j = 0;          //iΪ������Ҫ���ĸ���
        ListNode  slow, fast,head_;
        fast = slow = head_ = head;
        System.out.println("head_:"+head_.val);
        ListNode prev_middle = new ListNode(0);
        prev_middle.next = head;
        while(fast != null && fast.next != null)
        {
            prev_middle = prev_middle.next;
            slow = slow.next;
            fast = fast.next.next;
            i++;
        }//while1
        System.out.println("while1������������");
        head_ = head;
        while (head_!= null) {
			System.out.print(head_.val);
			head_ = head_.next;
		}
        System.out.println("slow:"+slow.val+"i:"+i);
        // slow = prev_middle;
        ListNode nex = slow.next;
        
        while(nex != null)
        {   
            ListNode nex_nex = nex.next;
            nex.next = slow;
            slow = nex;
            nex = nex_nex;
        }//while2
        int k =1;
        System.out.println("m"+k+"��next��value��"+m1.next.val);k++;
        System.out.println("m"+k+"��next��value��"+m2.next.val);k++;
        System.out.println("m"+k+"��next��value��"+m3.next.val);k++;
        System.out.println("m"+k+"��next��value��"+m4.next.val);k++;
//        System.out.println("m"+k+"��next��value��"+m5.next.val);k++;
        System.out.println("slow.val:"+slow.val);
        
        System.out.println("while2������������");
        head_ = head;
//        while (head_!= null) {
//        	System.out.println("while2������������");
//			System.out.print(head_.val);
//			head_ = head_.next;
//		}
        
        System.out.println("while2û����ѭ��"+"while2���������");


        head_ = head;
        System.out.println("��ת���֣�");
        while(j < i)
        {
        	System.out.println("�Ƚϻ���"+head.val+"\t"+slow.val);
            System.out.println("while3��ѭ��");
            slow = slow.next;
            head = head.next;
            
            j++;
            System.out.println(j);
        }//while3
//        while (head_ != null) {
//			System.out.print(head_.val);
//			head_ = head_.next;
//		}
 //       System.out.println("while3û����ѭ��");
//        System.out.println(head_.val);
//        while (head != null) {
//        	System.out.println("while3����");
//			System.out.println(head.val);
//			head = head.next;
//		}
	}
}