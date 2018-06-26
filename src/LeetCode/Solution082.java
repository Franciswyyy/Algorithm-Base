package LeetCode;

public class Solution082 {

    public ListNode deleteDuplicates(ListNode head) {

        if(head == null ) return null;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while(head != null){
            int tmp = 1;   // 重复的个数
            while(head.next != null && head.next.val == head.val){
                head = head.next;
                tmp ++;
            }
            if(tmp == 1 ){
                pre = head;
                head = head.next;
            }else{
                pre.next = head.next;
                head = head.next;
            }
        }
        return dummy.next;
    }
}
