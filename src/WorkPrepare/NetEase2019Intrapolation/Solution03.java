package WorkPrepare.NetEase2019Intrapolation;

import java.util.Scanner;
import java.util.TreeMap;

public class Solution03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] apple = new int[n];
            for(int i = 0; i < n; i ++)
                apple[i] = sc.nextInt();
            int m = sc.nextInt();
            int[] acquire = new int[m];
            for(int i = 0; i < m; i ++)
                acquire[i] = sc.nextInt();

            helper(apple, acquire);
        }
    }

    private static void helper(int[] sums, int[] acquire){

        for(int i = 1; i < sums.length; i++){
            sums[i] += sums[i-1];
        }

        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>(
                (Integer o1, Integer o2) -> (o1.compareTo(o2))
        );

        for(int i = 0; i < sums.length; i ++){
            map.put(sums[i], i+1);
        }

        for(int i = 0; i < acquire.length; i ++){
            int res = map.get(map.ceilingKey(acquire[i]));
            System.out.println(res);
        }

    }


    private static void helper1(int[] sums, int[] acquire){

        for(int i = 1; i < sums.length; i ++)
            sums[i] += sums[i-1];
        for(int i = 0; i < acquire.length; i ++)
            System.out.println(binSearch(sums, acquire[i]) + 1);
    }
    private static int binSearch(int[] arr, int k){
        int mid = arr.length/2;
        if(k == mid)return mid;

        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(k < arr[mid]) end = mid-1;
            else if(k > arr[mid]) start = mid +1 ;
            else  return mid;
        }
        return start;
    }

}
