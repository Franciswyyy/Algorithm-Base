package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution022 {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        helper("", 0, 0,  n, res);
        return res;
    }

    public void helper(String prefix, int open, int close, int max, List<String> res){

        if(prefix.length() == max*2){
            res.add(prefix);
            return;
        }

        if(open < max){
            helper(prefix + "(", open+1, close, max, res);
        }
        if(close < open){  // 表示第一次不执行
            helper(prefix + ")", open, close+1, max, res);
        }
    }
}
