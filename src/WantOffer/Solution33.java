package WantOffer;

import LeetCode.ListNode;

public class Solution33 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int l1 = getLength(pHead1);
        int l2 = getLength(pHead2);

        ListNode longList = pHead1;
        ListNode shortList = pHead2;

        if(l2 > l1){
            longList = pHead2;
            shortList = pHead1;
        }
        int diff = Math.abs(l1-l2);
        for(int i = 0; i < diff; i ++){
            longList = longList.next;
        }
        while((longList != null) && (shortList != null) && (longList != shortList)){
            longList = longList.next;
            shortList = shortList.next;
        }
        return longList;

    }
    private int getLength(ListNode node){
        if(node == null) return 0;
        int res = 0;
        while(node != null){
            node = node.next;
            res++;
        }
        return res;
    }
}
