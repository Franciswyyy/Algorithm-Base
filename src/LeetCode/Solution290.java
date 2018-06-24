package LeetCode;

import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution290 {

    public static boolean wordPattern(String pattern, String str) {
         String[] arr = getWord1(str);
         if(pattern.length() != arr.length) return false;

        //String[] arr= str.split(" ");

         HashMap<Character, String> map = new HashMap<Character, String>();
         for(int i = 0; i < pattern.length(); i ++){
             char c = pattern.charAt(i);
             if(map.containsKey(c)){
                 if(!map.get(c).equals(arr[i])){
                     return false;
                 }
             }else{
                 if (map.containsValue(arr[i]))
                     return false;
                 map.put(c, arr[i]);

             }
         }
         return true;
    }

    public static void main(String[] args) {

        String p = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(p, str));

    }

    public static String[] getWord1(String str){
        if(str == null || str.length() == 0) return null;

        int num = 0;     //单词数
        int index = 0;   //空格的索引位
        do{
            num ++;
            index ++;
            index = str.indexOf(' ', index);
        }while(index != -1);

        int end = 0;
        String[] arr = new String[num];
        index = 0;
        for(int i = 0; i < num; i ++){
            end = str.indexOf(' ', index);
            if(end == -1){
                arr[i]=str.substring(index);
            }else {
                arr[i] = str.substring(index, end);
            }
            index = end + 1;
        }
        return arr;
    }

    public static void getWord(String str){
        StringTokenizer st = new StringTokenizer(str, ",!' '");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}
