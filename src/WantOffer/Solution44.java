package WantOffer;

import java.util.Stack;

public class Solution44 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) return false;

        Stack<Integer> stack = new Stack<>();

        int index = 0;
        for(int i = 0; i < pushA.length; i ++){
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
