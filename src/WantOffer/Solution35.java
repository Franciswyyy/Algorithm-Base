package WantOffer;

import LeetCode.ListNode;

public class Solution35 {

    public static ListNode meetingNode(ListNode head) {

        if(head == null || head.next == null || head.next.next == null)return null;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        //先判断是否有环
        while (slow != fast){
            if(fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }else {
                //没有环
                return null;
            }
        }

        //有环就停止，fast == slow
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
