package WorkPrepare.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution021 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int len = sc.nextInt();
            int k = sc.nextInt();
            int t = sc.nextInt();
            int[] num = new int[len];
            for(int i = 0; i < len; i ++){
                num[i] = sc.nextInt();
            }
            System.out.println(helper(num, k, t));
        }
    }
    private static int helper(int[] arr, int k, int t){
        if(k > arr.length || t > arr.length) return 0;
        int res = 0;
        int l = 0;
        int r = k-1;
        while(r < arr.length){
            boolean flag = helper2( arr,  l,  r,  t);
            if(flag == true) res++;
            l++;
            r++;
        }
        return res;
    }
    private static boolean helper2(int[] arr, int l, int r, int t){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = l; i <= r; i ++){
            if(map.keySet().contains(arr[i])){
                int count = map.get(arr[i]);
                map.put(arr[i], count+1);
                if(count + 1 == t) return true;
            }else {
                map.put(arr[i], 1);
            }
        }
        return false;
    }

}
