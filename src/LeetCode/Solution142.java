package LeetCode;

public class Solution142 {

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        boolean flag = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                flag = true;
                break;
            }
        }

        if(!flag) return null;
        ListNode tmp = head;
        while(tmp != slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        return slow;
    }
}
