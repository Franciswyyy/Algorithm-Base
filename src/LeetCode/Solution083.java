package LeetCode;

public class Solution083 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null ) return null;

        ListNode dummy = new ListNode(0);
        dummy = head;
        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null){
            while(cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            pre.next = cur;
            cur = cur.next;
            pre = pre.next;
        }
        return dummy.next;
    }
}
