package Algorithm.sortQuick.sortQuestion;

import java.util.Arrays;

/**
 * 逆序对~ 归并思想
 */

public class InversionCount {
    private InversionCount() {
    }

    private static long merge(Comparable[] arr, int l, int mid, int r){

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        long res = 0L;

        int i = l, j = mid+1;
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = aux[j-l];
                j++;
            }else if(j > r){
                arr[k] = aux[i-l];
                i ++;
            }else if(aux[i-l].compareTo(aux[j-l]) <= 0){
                arr[k] = aux[i-l];
                i ++;
            }else {  //右边小于左边
                arr[k] = aux[j-l];
                j ++;

                // 重点的部分啦
                res += (long)(mid - i + 1);
            }
        }
        return res;
    }

    private static long solve(Comparable[] arr, int l, int r){

        if(l >= r) return 0L;

        int mid = (r-l)/2 + l;
        long res1 = solve(arr, l, mid);
        long res2 = solve(arr, mid+1, r);

        return res1 + res2 + merge(arr, l, mid, r);
    }

    public static long solve(Comparable[] arr){
        int n = arr.length;
        return solve(arr, 0, n-1);
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,6,7,0};
        System.out.println(solve(arr));
    }
}
