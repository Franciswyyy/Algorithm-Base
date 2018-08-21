package WantOffer;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class Solution08 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack2.isEmpty() && stack1.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

}
