package WantOffer;

import java.util.Stack;

public class Solution43 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();  // 临时栈
    // 每次用一个辅助栈来存最小值

    public void push(int value) {
        stack1.push(value);
        if(stack2.isEmpty()){
            stack2.push(value);
        }else if(value <= stack2.peek()){
            stack2.push(value);
        }
    }

    public void pop() {
        if(stack1.peek() == stack2.peek()) stack2.pop();
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
