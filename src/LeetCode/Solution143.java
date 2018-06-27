package LeetCode;

public class Solution143 {

    public void reorderList(ListNode head) {

        if(head == null || head.next == null) return;

        // 找list中间的节点
        ListNode p1 = head;
        ListNode p2 = head;
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // 开始反转后半部分 ,
        ListNode pre = p1;
        ListNode cur = p1.next;
        while(cur.next != null){
            ListNode next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        p1 = head;
        p2 = pre.next;

        while(p1 != pre){
            pre.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;   // p1 下一个
            p2 = pre.next;
        }

    }
}
