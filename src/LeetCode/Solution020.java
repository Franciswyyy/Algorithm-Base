package LeetCode;

import java.util.Stack;

public class Solution020 {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if( c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if( c == '['){
                stack.push(']');
            } else if(stack.size() == 0 ||  !stack.pop().equals(c)){
                    return false;
            }
        }

        if(stack.size() != 0) return false;
        return true;
    }
}
