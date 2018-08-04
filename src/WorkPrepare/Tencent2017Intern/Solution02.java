package WorkPrepare.Tencent2017Intern;

import java.util.Scanner;

public class Solution02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            System.out.println(helper(str));
        }
    }

    private static String helper(String str){

        if(str == null || str.length() == 0) return null;

        char[] chars = str.toCharArray();
        int index = 0;
        for(int i = 0; i < chars.length; i ++){
            Character c = chars[i];
            // 插入排序
            if(Character.isLowerCase(c)){
                char tmp = chars[i];
                int j = i;
                for(; j-1 >= index; j --){
                    chars[j] = chars[j-1];
               }
               chars[j] = tmp;
                chars[index++] = c;
            }
        }
        return String.valueOf(chars);
    }

}
