package LeetCode;

public class Solution019 {

    // 先遍历一遍获取该链表的长度，都是从1开始的, 题目说了给定的n总是有效的
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode dummy = new ListNode(0);   // 虚拟头节点为-1
        dummy.next = head;
        ListNode pre = head;
        int len = 0;
        while(pre != null){
            ++ len;
            pre = pre.next;
        }

        int index = len - n;  // 删除节点的前一个位置
        pre = dummy;  //防止删除第一个
        int i = 0;
        while(i != index){
            pre = pre.next;
            ++ i;
        }
        pre.next = pre.next.next;    // pre.next 肯定不为null，这个是要删除的节点
        return dummy.next;
    }


    // 初始化两个指针，一前一后
    public ListNode removeNthFromEnd1(ListNode head, int n){

        // 尽然n有效，就不用管长度不够了
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(n != 0){
            cur = cur.next;
            -- n;
        }

        while(cur.next != null){
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;

    }
}
