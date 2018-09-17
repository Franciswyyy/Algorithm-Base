package WorkPrepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class test12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int[] goods = new int[n];
            for(int i = 0; i < n; i ++){
                goods[i] = sc.nextInt();
            }
            ArrayList<Integer> AList = new ArrayList<>();
            ArrayList<Integer> BList = new ArrayList<>();
            for(int i = 0; i < m; i ++){
                if(sc.next().equals('B')){
                    BList.add(sc.nextInt());
                } else{
                    AList.add(sc.nextInt());
                }
            }

            System.out.println(helper(goods, AList, BList, p));
        }
    }
    private static int helper(int[] goods, ArrayList<Integer> alist, ArrayList<Integer> blist, int p){
        for(int i : alist){
            goods[i-1] = goods[i-1] +1;
        }
        for(int i : blist){
            goods[i-1] = goods[i-1] -1;
        }
        int value = goods[p-1];
        int res = 0;
        for(int i = 0; i < goods.length; i ++){
            if(value < goods[i]){
                res ++;
            }
        }
        return res;
    }
}
