package LeetCode;

public class Solution025 {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || head.next == null || k < 2){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode tail = dummy;  // 指向结尾的点
        ListNode tailNext;      // 执行下一轮开始的第一个点，也是为了上一轮结束的标志
        ListNode cur;
        ListNode next;
        int count;
        while(true){

            count = k;
            while(tail != null && count != 0){    // 为什么不是tail.next，只要保证当前有k个就可以了，而不用管k+1有没有值
                tail = tail.next;
                count--;
            }

            if(tail == null) break;


            tailNext = tail.next;
            cur = pre.next;
            next = cur.next;
            while(cur.next != tailNext){
                cur.next = next.next;
                next.next = pre.next;
                pre.next = next;
                next = cur.next;
            }
            tail = cur;
            pre = cur;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5};
        ListNode list = new ListNode(arr);

        ListNode a = reverseKGroup(list, 2);
        System.out.println(a);
    }
}
