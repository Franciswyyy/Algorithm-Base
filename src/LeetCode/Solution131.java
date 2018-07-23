package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(0, s, new ArrayList<>(), res);
        return res;
    }

    public void helper(int start, String s, List<String>cur, List<List<String>>res){

        if(start == s.length()){
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < s.length(); i ++){
            if(isPalindrome(s, start, i)){
                cur.add(s.substring(start, i+1));   // 前闭后开
                helper(i + 1, s, cur, res);
                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s, int low, int high){
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--)) return false;
        }
        return true;
    }
}
