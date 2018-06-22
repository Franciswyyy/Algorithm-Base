package LeetCode;

public class Solution345 {

    public static String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;

        String vowels = "aeiouAEIOU";
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length-1;

        while (i < j){

            while(i < j && !vowels.contains(chars[i] + "")){
                i ++;
            }


            while(i < j && !vowels.contains(chars[j] + "")){
                j --;
            }


            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;

            i ++;
            j --;
        }
        return String.valueOf(chars);   // new String(chars)
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseVowels(s));
    }
}
