package LeetCode;

import java.util.HashMap;

public class Solution003 {

    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {

        if(s.length() <= 0 || s == null)
            throw new IllegalArgumentException("Illigal Arguments");

        boolean[] freq = new boolean[256];
        char[] chars = s.toCharArray();
        int l = 0, r = -1;
        int res = 0;

        while(l < chars.length){

            if(r + 1 < chars.length && !freq[chars [r+1]]){    //false表示还没访问
                freq[chars[++r]] = true;
            }else{   // 右边界不能扩展了，只能左边扩展了
                freq[chars[l++]] = false;
            }

            res = Math.max(res, r-l+1);
        }
        return res;

    }


    public int lengthOfLongestSubstring1(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
