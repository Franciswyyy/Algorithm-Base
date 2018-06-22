package LeetCode;

public class Solution076 {

    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) return "";

        int[] hash = new int[256];
        char[] str = s.toCharArray();
        for(char c : t.toCharArray()){
            hash[c] ++;
        }

        int left = 0;
        int right = 0;
        int count = t.length();
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;
        while(right < s.length()){
            if(hash[str[right]] > 0){
                count--;
            }
            hash[str[right]] --;

           while(count == 0){
               if(right - left + 1 < minLen){
                   minLen = right - left + 1;
                   minLeft = left;
               }

               hash[str[left]] ++;
               //说明这个是已经添加过的，即是t里的，否则减去之后减成负数了
               if(hash[str[left]] > 0){
                   count ++;
               }
               left ++;
           }
           right++;
        }
        if(minLeft + minLen > s.length()) return  "";
        return s.substring(minLeft, minLeft+minLen);
    }
}
