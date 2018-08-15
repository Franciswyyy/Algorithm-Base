package WorkPrepare.NetEase2019Intrapolation;

import java.util.Scanner;

public class Solution02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] value = new int[n];
            int[] awake = new int[n];
            for (int i = 0; i < n; i++)
                value[i] = sc.nextInt();
            for (int i = 0; i < n; i++)
                awake[i] = sc.nextInt();
//            int[] value = new int[]{6481,6127,4477,5436,7356,3137,1076,7182,8147,835};
//            int[] awake = new int[]{1,0,1,0,1,1,0,0,0,1};
//            int k = 5;
            System.out.println(helper1(value, awake, k));
        }
    }

    // 通过90
    private static int helper(int[] score, int[] sleep, int k){
        int n = score.length;
        int sum = 0;
        for(int i = 0; i < n; i ++){
            if(sleep[i] == 1) sum += score[i];
        }

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < n; i ++){
            if(sleep[i] == 0){
                int temp = sum;
                for(int j = i; j < Math.min(i+k, n); j++){
                    if(sleep[j] == 0) temp += score[j];
                }
                res = Math.max(temp, res);
            }
        }
        return res;
    }

    private static int helper1(int[] scores, int[] sleep, int k){
        int n = scores.length;

        int sum = 0;
        int total = 0;
        for(int i = 0; i < n; i ++){
            if(sleep[i] == 1) sum += scores[i];
            total += scores[i];
        }

        if(k >= n) return total;


        int res = 0;
        int l = 0, r = -1;
        // k大的窗口
        while(r != k-1) {
            if(sleep[++r] == 0){
                sum += scores[r];
            }

        }
        int temp = sum;    //错误之一，写在里面，导致每次的窗口大小都是初始值。
        while(r < n-1){
            if(sleep[++r] == 0) temp+=scores[r];
            if(sleep[l] == 1) ++l;
            else temp -= scores[l++];
            res = Math.max(res, temp);
        }
        return res;

    }
}
