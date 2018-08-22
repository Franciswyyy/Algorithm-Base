package WantOffer;

import LeetCode.ListNode;

public class Solution16 {
    public ListNode ReverseList(ListNode head) {
        ListNode dummy = null;
        while(head != null){
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
        return dummy;
    }
}
