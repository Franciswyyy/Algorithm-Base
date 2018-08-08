package WorkPrepare.Pinduoduo2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Solution01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           String str = sc.nextLine();
            helper(str);
        }
    }

    private static void helper(String str){
        int len = str.length();
        int k = len/4;

        char[] chars = str.toCharArray();
        int index = 0;
        for(; index < k+1; index ++)
            System.out.print(chars[index]);
        System.out.println();

        Queue<Character> queue = new LinkedList<>();
        int last = chars.length-1;
        for(int i = 0; i < k-1; i ++){
            queue.add(chars[last--]);
            int j = 0;
            while(j != k-1){
                queue.add(' ');
                j++;
            }
            queue.add(chars[index++]);
        }
        while(last >= index){
            queue.add(chars[last--]);
        }


        for(int i = 0; !queue.isEmpty(); i++){
            if(i != 0 && i % (k+1) == 0){
                System.out.println();
            }
            System.out.print(queue.poll());
        }

    }
}
