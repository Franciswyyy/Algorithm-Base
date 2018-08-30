package WantOffer;

import LeetCode.ListNode;

public class Solution16 {
    public ListNode ReverseList(ListNode head) {
        ListNode dummy = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }

    public ListNode ReverseList01(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while(head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}