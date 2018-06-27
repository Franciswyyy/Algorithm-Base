package LeetCode;

public class Solution148 {

    public ListNode sortList(ListNode head) {

        // 当不存在或者只存在一个节点的话，直接返回
        if(head == null || head.next == null) return head;

        // pre是第二个头结点的前一个， slow是第二个的头结点
        ListNode pre=null, slow=head, fast=head;

        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        pre = null;   // 将第一条和第二条分开

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }



    // 此时两个链表都是有序的
    public ListNode merge(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);

        ListNode pre = dummy;

        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else{
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if(l1 != null){
            pre.next = l1;
        }

        if(l2 != null){
            pre.next = l2;
        }

        return dummy.next;
    }
}
