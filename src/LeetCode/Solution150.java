package LeetCode;

import java.util.Stack;

public class Solution150 {

    // 简写风格
    public int evalRPN12(String[] tokens) {
        int a, b;
        Stack<Integer> stack = new Stack<Integer>();
        for(String s : tokens){
            if(s.equals("+")){
                stack.push(stack.pop() + stack.pop());
            }else if(s.equals("/")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b/a);
            }else if(s.equals("*")){
                stack.push(stack.pop() * stack.pop());
            }else if(s.equals("-")){
                a = stack.pop();
                b = stack.pop();
                stack.push(b-a);
            }else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }



    // 给定的逆波兰式总是有效的， 给的是整数，除法就只是保留整数部分
    public static int evalRPN(String[] tokens) {

        Stack<String> stack= new Stack<>();
        for(int i = 0; i < tokens.length; i ++){
            String str = tokens[i];
            if(str.equals("+")){
                Integer num1 = str2int(stack.pop());
                Integer num2 = str2int(stack.pop());
                Integer res = num1 + num2;
                stack.push(res.toString());
            }else if(str.equals("-")){
                Integer num1 = str2int(stack.pop());
                Integer num2 = str2int(stack.pop());
                Integer res = num2 - num1;
                stack.push(res.toString());
            }else if(str.equals("*")){
                Integer num1 = str2int(stack.pop());
                Integer num2 = str2int(stack.pop());
                Integer res = num1 * num2;
                stack.push(res.toString());
            }else if(str.equals("/")){
                Integer num1 = str2int(stack.pop());
                Integer num2 = str2int(stack.pop());
                Integer res = num2 / num1;
                stack.push(res.toString());
            } else{
                stack.push(str);
            }
        }
        int res = str2int(stack.pop());
        return res;
    }

    // 字符串转整数
    public static Integer str2int(String str){
        int res = 0;
        int num = 1;
        int  flag = 1;
        if(str.charAt(0) == '-'){
            flag = -1;
        }
        for(int i = str.length()-1; i >= 0; i --){
            if(str.charAt(i) == '-') break;
            int var = str.charAt(i) - '0';
            res = res + var * num;
            num *= 10;
        }
        return res*flag;
    }

    public static void main(String[] args) {

        String[] strs= new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(strs));
    }


}
