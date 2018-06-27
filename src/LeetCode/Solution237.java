package LeetCode;

public class Solution237 {

    public void deleteNode(ListNode node) {

        ListNode pre = null;
        while(node.next != null){
            pre = node;
            node.val = node.next.val;
            node = node.next;
        }
        pre.next = null;
    }
}
