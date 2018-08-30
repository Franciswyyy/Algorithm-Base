package WantOffer;

import LeetCode.ListNode;

public class Solution15 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if(head == null || k <= 0) return null;

        ListNode pre = head;
        ListNode cur = head;
        for(int i = 1; i < k; i ++){
            // 已经判断了链表是否存在k个结点
            if(pre.next != null) pre = pre.next;
            else return null;
        }
        while(pre.next != null){
            pre = pre.next;
            cur = cur.next;
        }
        return cur;
    }
}
