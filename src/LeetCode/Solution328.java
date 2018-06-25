package LeetCode;

public class Solution328 {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode headEven = even;

        while(even != null && even.next != null){

            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = headEven;
        return head;
    }
}
