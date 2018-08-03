import javafx.util.Pair;

import java.util.*;

public class test {


    public static void main(String[] args) {
        System.out.println(helper("aaasdfssseeeeggggaaaaaxxxxxsssccccc"));
    }

    public static String helper(String str){

        if(str == null) return null;

        HashMap<Character, Integer> map = new HashMap();


        char[] chars = str.toCharArray();

        boolean flag = true;
        int start = 1;
        for(int i = 1 ; i < chars.length; i ++){
            if(chars[i] == chars[i-1] && i != chars.length-1){
                start = flag ? i-1 : start;
                flag = false;
            }else{
                if(i == chars.length-1){
                    map.put(str.charAt(i),i-start+1);
                    break;
                }
                map.put(str.charAt(i-1),i-start);
                flag = true;

            }


        }


        int max = 0;
        Character c = '0';
       for(Map.Entry<Character, Integer> entry: map.entrySet()){
            if(entry.getValue() > max){
                c = entry.getKey();
                max = entry.getValue();
            }else if(entry.getValue() == max){
                if(entry.getKey() < c){
                    c = entry.getKey();
                }
            }
       }

       StringBuffer sb = new StringBuffer();
        while(max != 0){
            sb.append(c);
            max--;
        }
        return String.valueOf(sb);

}

    public static int helper1(int[] nums){

        int k = nums[nums.length-1];
        int[] res = new int[nums.length-1];
        return 0;
    }

}
