package WorkPrepare.今日头条;

import java.util.Scanner;

public class Solution03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i = 0; i < n; i ++){
                int num = sc.nextInt();
                String[] strings = new String[num];
                for(int j = 0; j < num; j++){
                    strings[j] = sc.nextLine();
                }
                for(int k = 1; k < num; k ++){
                    if(helper(strings[0], strings[k])){
                        System.out.println("Yeah");
                        break;
                    }
                }
                System.out.println("Sad");
            }
        }

    }

    public static boolean helper(String str1, String str2){
        if(str1.length() != str2.length()) return false;

        StringBuffer sb1 = new StringBuffer(str1);
        sb1.reverse();
        String one = str1 + str1;
        String two = sb1.append(sb1).toString();

        if(one.contains(str2)) return true;
        else if(two.contains(str2)) return true;
        else return false;
    }
}
