package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution093 {

    // 题目规定了都是数字字符
    public List<String> restoreIpAddresses(String s) {

        List<String> res = new ArrayList<String>();

        if(s == null || s.length() == 0 || s.length() < 4 || s.length() > 12) return res;

        helper(s, 0, 0,"", res);

        return res;
    }

    private void helper(String ip, int idx, int count, String restored, List<String> res){


        for(int i = 1; i < 4; i ++){
            if(idx + i > ip.length()) break;
            String s = ip.substring(idx, idx+i);
            if((s.startsWith("0") && s.length() > 1) || (i==3 && Integer.parseInt(s) >= 256)) continue;
            helper(ip, idx+i, count+1, restored + s + (count == 3 ? "" : "."), res);
        }
    }
}
