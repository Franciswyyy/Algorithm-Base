package WorkPrepare.NetEase2019Intrapolation;

import java.util.Scanner;

// 题目已经说明了总共3个数
public class Solution05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            System.out.println(helper(a, b, c));
        }
    }

    private static int helper(int a, int b, int c){
        return Math.max(maxRes(maxRes(a, b), c),maxRes(a, maxRes(b, c)));
    }
    private static int maxRes(int a, int b){
        return Math.max(a+b, a*b);
    }
}
