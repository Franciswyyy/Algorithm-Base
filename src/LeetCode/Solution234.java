package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution234 {

    // 利用了数组
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return false;

        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        int i = 0;
        int j = list.size();
        while(i < j){
            if(list.get(i).equals(list.get(j))){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head){
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
