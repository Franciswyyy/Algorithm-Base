package LeetCode;

public class Solution344 {

    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;

        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;

        while (i < j){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;

            i ++;
            j --;
        }
        return String.valueOf(chars);
    }


    public String reverseString1(String s) {
        StringBuffer sb = new StringBuffer(s);
        return sb.reverse().toString();
    }

}
