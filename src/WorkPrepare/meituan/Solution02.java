package WorkPrepare.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution02 {

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
        if(arr.length < t || arr.length < k) return 0;

        int l = 0, r = -1;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        while(r+1 < arr.length){

            if(r-l+1 == k) flag = true;
            if(flag){
                if(l+1 < arr.length && l-r+1 == k){
                    map.put(arr[r], map.get(arr[r]) - 1);
                    map.put(arr[l+1], map.get(arr[l + 1])+1);
                    r++;
                    k++;
                }
            }

            while(r+1 < arr.length &&  r+1-l < k){
                map.put(arr[r+1], map.getOrDefault(arr[r+1], 0) + 1);
                r++;
            }


            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getValue() > t){
                    res++;
                    break;
                }
            }

        }
        return res;
    }
}
