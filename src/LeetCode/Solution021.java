package LeetCode;

public class Solution021 {

    // 显然可以用递归来做。。。
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null && l1.val < l2.val){
                cur.next = l1;
                cur = l1;
                l1 = l1.next;
            }else if(l1 != null && l2 != null && l1.val >= l2.val){
                cur.next = l2;
                cur = l2;
                l2 = l2.next;
            }

            if(l1 == null && l2 != null){
                while(l2 != null){
                    cur.next = l2;
                    cur = l2;
                    l2 = l2.next;
                }
            }

            if(l2 == null && l1 != null){
                while(l1 != null){
                    cur.next = l1;
                    cur = l1;
                    l1 = l1.next;
                }
            }
        }
        return dummy.next;
    }
}
