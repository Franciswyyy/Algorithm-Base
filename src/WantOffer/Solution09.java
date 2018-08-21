package WantOffer;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;

/**
 * 两个队列实现栈
 */
public class Solution09 {

    ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    ArrayDeque<Integer> queue2 = new ArrayDeque<>();

    public void push(int element){
        queue1.offer(element);
    }

    //将form队列元素出队，并依次入队到to队列，直到from队列中只有一个队列
    public void move(ArrayDeque<Integer> from, ArrayDeque<Integer>to){
        while(from.size() > 1){
            to.offer(from.poll());
        }
    }

    public int pop(){
        if(!queue1.isEmpty() || !queue2.isEmpty()){
            if(!queue1.isEmpty()){
                move(queue1, queue2);
                return queue1.poll();
                //queue1队列pop后就为空了
            }else if(!queue2.isEmpty()){
                move(queue2, queue1);
                return queue2.poll();
            }
        }
        throw new RuntimeException("queue is null");
    }

    public static void main(String[] args) {
        Solution09 s = new Solution09();
        s.push(12);
        s.push(1);
        s.push(45);
        s.push(12);
        System.out.println(s.pop());
        System.out.println(s.pop());
        s.push(123);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
