package LeetCode;

public class Solution061 {

    public ListNode rotateRight(ListNode head, int k) {

        if(head == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;

        int len = 0;
        while(fast.next != null){
            ++ len;
            fast = fast.next;
        }
        // 此时fast指向最后一个节点

        if(k >= len){
            k = k % len;
        }
        if(k == 0) return head;

        int j = len - k; // 要移动节点的前一个节点的位置
        ListNode slow = dummy;
        while(j != 0){
            j --;
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return  dummy.next;
    }
}
