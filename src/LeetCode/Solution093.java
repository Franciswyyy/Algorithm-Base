package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution093 {

    // 题目规定了都是数字字符
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<String>();

        helper(s, 0,"", res);

        return res;
    }

    private void helper(String s, int start, String tmp, List<String> res){

        if(start == 4){
            if(s.length()==0) res.add(tmp.substring(0,tmp.length()-1));
            //substring here to get rid of last '.'
            return;
        }

        for(int k = 1; k <= 3; k ++){
            if(s.length() < k) continue;
            int val = Integer.parseInt(s.substring(0,k));
            if(val > 255 || k != String.valueOf(val).length()) continue;
             /*in the case 010 the parseInt will return len=2 where val=10, but k=3, skip this.*/
            helper(s.substring(k),start+1, tmp + s.substring(0,k)+".",res);
        }

    }
}
