package WorkPrepare.Pinduoduo2018;

import java.util.Scanner;

public class Solution02{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next().trim();
        int sum = 0;
        for(int i = 1; i < s.length(); i ++){
            String s1 = s.substring(0, i);
            String s2 = s.substring(i, s.length());
            if(incr(s1) && incr(s2)){
                sum ++;
                for(int j = 1; j < s1.length(); j ++){
                    if(dec(s1, j)){
                        sum ++;
                    }
                }
                for(int j = 1; j < s2.length(); j ++){
                    if(dec(s2, j)){
                        sum ++;
                    }
                }
            }
            for(int j = 1; j < s1.length(); j ++){
                if(!incr(s1) && dec(s1, j) && incr(s2)){
                    sum ++;
                }
                if(!incr(s1) && !incr(s2) && dec(s1, j)){
                    for(int m = 1; m < s2.length(); m ++){
                        if(dec(s2, m)){
                            sum ++;
                        }
                    }
                }
            }
            for(int j = 1; j < s2.length(); j ++){
                if(incr(s1) && dec(s2, j) && !incr(s2)){
                    sum ++;
                }
            }

        }
        System.out.println(sum);
    }
    public static boolean incr(String s){
        if(s.length() != 1 && (s.charAt(0) == '0' || s.charAt(s.length() - 1) == '0')){
            return false;
        }
        return true;
    }
    public static boolean dec(String s, int i){
        if((i != 1 && s.charAt(0) == '0') || s.charAt(s.length() - 1) == '0'){
            return false;
        }
        return true;
    }

}