package LeetCode;

public class Solution002 {

    // 肯定不会在链表上相加，  链表非空，且没有负数
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum1 = 0;
        int i = 0;
        while(l1 != null){

            int num = l1.val;

            sum1 = sum1 +(int)(num*Math.pow(10, i ++));
            l1 = l1.next;
        }

        int sum2 = 0;
        int j = 0;
        while(l2 != null){

            int num = l2.val;

            sum2 = sum2 +(int)(num*Math.pow(10, j ++));
            l2 = l2.next;
        }


        int sum = sum1 + sum2;
        if(sum == 0) return new ListNode(0);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(sum != 0){
            int tmp = sum % 10;
            ListNode node = new ListNode(tmp);
            cur.next = node;
            cur = cur.next;
            sum /= 10;
        }
        return dummy.next;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
        int[] arr1 = new int[]{1,2};
        ListNode l1 = new ListNode(arr);
        ListNode l2 = new ListNode(arr1);
        System.out.println(addTwoNumbers(l1, l2));

        System.out.println(Integer.MIN_VALUE);
    }
}
