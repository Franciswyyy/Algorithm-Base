package LeetCode;

public class Solution024 {

    public ListNode swapPairs(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node1;
        ListNode node2;
        ListNode next;
        while(pre.next != null && pre.next.next != null){
            node1 = pre.next;
            node2 = pre.next.next;
            next = pre.next.next.next;

            node1.next = next;
            pre.next = node2;
            node2.next = node1;

            pre = node1;
        }
        return dummy.next;
    }
}
