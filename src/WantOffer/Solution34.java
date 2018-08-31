package WantOffer;

import LeetCode.ListNode;

// 重复的节点不保留
public class Solution34 {
    public ListNode deleteDuplication(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                int val = cur.val;
                while(cur != null && cur.val == val)
                    cur = cur.next;
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
