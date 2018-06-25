package LeetCode;

public class Solution092 {

    // 链表起始从1开始计数
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) return null;
        if(m > n ) return head;

        //计算链表的长度
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            ++ len;
            cur = cur.next;
        }
        if(len < m) return head;


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < m-1; i ++){
            pre = pre.next;
        }

        cur = pre.next;
        ListNode next = cur.next;

        for(int i = 0; i < n-m; i ++){
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
            next = cur.next;
        }

        return dummy.next;
    }
}
