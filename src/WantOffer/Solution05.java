package WantOffer;

import LeetCode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Solution05 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    ArrayList<Integer> res1 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {

        if(listNode != null){
            printListFromTailToHead(listNode.next);
            res1.add(listNode.val);
        }
        return res1;
    }

    public ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
        ListNode dummy = new ListNode(-1);
        while(listNode != null){
            ListNode next = listNode.next;
            listNode.next = dummy.next;
            dummy.next = listNode;
            listNode = next;
        }

        ArrayList<Integer> res = new ArrayList<>();
        dummy = dummy.next;
        while(dummy != null){
            res.add(dummy.val);
            dummy = dummy.next;
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4);
        List<Integer> res1 = Arrays.asList(5,6);
        list.forEach((s) -> System.out.println(s));
        System.out.println("---分割线---");
        res1.forEach(System.out::println);
        System.out.println("---分割线---");
        list.addAll(res1);    //没有这一说法。
        list.forEach(System.out::println);
    }
}
