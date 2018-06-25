package LeetCode;

public class Solution086 {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);

        ListNode cur1 = dummy1, cur2 = dummy2;

        while(head != null){
            if(head.val < x){
                cur1.next = head;
                cur1 = cur1.next;
                head = head.next;
            }else{
                cur2.next = head;
                cur2 = cur2.next;
                head = head.next;
            }
        }
        cur1.next = null;
        cur2.next = null;

        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
