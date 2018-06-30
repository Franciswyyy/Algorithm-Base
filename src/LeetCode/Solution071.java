package LeetCode;

import java.util.*;

public class Solution071 {

    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".",""));
        for(String cur : path.split("/")){
            if(cur.equals("..") && !stack.isEmpty()) stack.pop();
            else if(!skip.contains(cur)) stack.push(cur);
        }
        String res = "";
        for(String dir : stack){
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }


    public static String simplifyPath11(String path) {
        Stack<Character> stack = new Stack<>();
        char pre = ' ';
        int tmp = 0;
        for(char cur : path.toCharArray()){
            if(stack.size() == 0){
                stack.push(cur);
                pre = cur;
                continue;
            }
            else if(pre == '/' && cur == '/'){
                continue;
            }
            else if(pre != '.' && cur == '.'){
                stack.push('.');
                pre = '.';
            }
            else if(pre == '.' && cur == '.'){
                tmp = 0;
                while(tmp != 2){
                    if(stack.size() == 0){
                        break;
                    }
                    if(stack.pop() == '/'){
                        ++ tmp;
                        if(stack.size() != 0){
                            pre = stack.peek();
                        }
                    }
                }
            }
            else if(pre == '.' && cur == '/' ){
                stack.pop();
                pre = stack.peek();
                continue;
            }
            else {
                stack.push(cur);
                pre = cur;
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        if(sb.charAt(0) == '/'){
            sb.deleteCharAt(0);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "/a/./b/../../c/";
        String str1 = "/home/";
        String str2= "/w//yu1/./saf/../../y/z/";

    }
}
