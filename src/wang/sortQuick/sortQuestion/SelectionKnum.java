package wang.sortQuick.sortQuestion;

import wang.sortTestHelp.SortTestHelper;

/**
 * 取数组第k小的元素 , k
 */
public class SelectionKnum {

    private SelectionKnum(){}

    private static int partiton(Comparable[] arr, int l, int r){

        SortTestHelper.swap(arr, l, (int)(Math.random()*(r-l+1))+l);

        Comparable v = arr[l];

        int j = l;
        for(int i = l + 1; i <= r; i++){
            if(arr[i].compareTo(v) < 0){
                j ++;
                SortTestHelper.swap(arr, j, i);
            }
            SortTestHelper.swap(arr, l, j);
        }
        return j;
    }


    //求arr数组中[l...r]范围里第k小的数
    private static Comparable solve(Comparable[] arr, int l, int r, int k){

        if( l == r ) return arr[l];

        int p = partiton(arr, l, r);

        if(k == p){
            return arr[p];
        }else if(k < p){
            return solve(arr, l, p-1, k);
        }else if(k > p) {
            return solve(arr, p + 1, r, k);
        }
        return null;
    }


    //这里k为0，即最小的数为第0小的数
    public static Comparable solve(Comparable[] arr, int k){
        assert arr != null && k >= 0 && k < arr.length;
        return solve(arr, 0, arr.length - 1, k);
    }

    //如果k从1开始的，即最小的为第1个数
    public static Comparable solve2(Comparable[] arr, int k){
        return solve(arr, k-1);
    }

    public static void main(String[] args) {
        Integer[] arr = {2,3,1,5,7};
        System.out.println(solve(arr, 2));
    }
}
