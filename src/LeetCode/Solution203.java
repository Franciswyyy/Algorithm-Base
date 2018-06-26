package LeetCode;

public class Solution203 {

    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(head != null){
            if(head.val == val){
                pre.next = head.next;
                head = head.next;
                continue;
            }
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }

}
