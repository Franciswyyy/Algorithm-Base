package LeetCode;

public class Solution206 {

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode cur = head;
        ListNode pre = null;

        while(cur != null){
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        int[] arr = {1,67,4,8,20};
        ListNode head = new ListNode(arr);

        System.out.println(head);

        ListNode head2 = reverseList(head);
        System.out.println(head2);
    }
}
