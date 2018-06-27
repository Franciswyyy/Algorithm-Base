package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Solution147 {

    // 全部拿出来排好序再重新生成一个链表
    public static ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        List<Integer> list = new ArrayList<Integer>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);

        Iterator<Integer> iter = list.iterator();
        while(iter.hasNext()){
            pre.next = new ListNode(iter.next());
            pre = pre.next;
        }
        return dummy.next;
    }


    // 从 第一个点已经是固定的，从head.next下一个开始
    public static ListNode insertionSortList1(ListNode head) {

       if(head == null || head.next == null) return head;

       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode cur = head.next;
       ListNode pre = dummy;
       ListNode next;
       int i = 1;
       while(cur != null){

           next = cur.next;

           // 不能等于
           while(pre.next != null && pre.next.val < cur.val){
               pre = pre.next;
           }

           if(pre.next == cur){
               pre = dummy;
               cur = next;
               break;
           }

           cur.next = pre.next;

           // 得自己断一下，否则会成死循环，只执行一次
           if(i != 0 ){
               pre.next.next = null;
               i--;
           }
           pre.next = cur;
           pre = dummy;
           cur = next;
       }
       return dummy.next;
    }

    // 直接 新建一个节点，当然这个节点是最小的，然后一直往后插入节点
    public static ListNode insert(ListNode head){

        if(head == null) return null;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next;

        while(cur != null){

            next = cur.next;

            // 不需要建立，只要当是只有一个dummy时，就直接插入节点后面。
            while(pre.next != null && pre.next.val < cur.val){
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;

            cur = next;
            pre = dummy;
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,2,1,3};
        ListNode list = new ListNode(arr);
        System.out.println(insert(list));

    }
}
