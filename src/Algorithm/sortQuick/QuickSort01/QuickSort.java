package Algorithm.sortQuick.QuickSort01;

import Algorithm.sort.InsertionSort02.InsertionSortoptimize;
import Algorithm.sortTestHelp.SortTestHelper;

public class QuickSort {

    private QuickSort() {
    }

    private static int partition(Comparable[] arr, int l, int r){

        SortTestHelper.swap(arr, l, (int)(Math.random()*(r-l+1)) + l);
        Comparable v = arr[l];

        int j = l;    // arr[l+1...j] < v ; arr[j+1...i) >
        for(int i = l + 1; i <= r; i ++){
            if(arr[i].compareTo(v) < 0){
                j ++;
                SortTestHelper.swap(arr, j, i);
            }
        }
        SortTestHelper.swap(arr, l, j);
        return j;
    }

    private static void sort(Comparable[] arr, int l, int r){

        if( r - l <= 15){
            InsertionSortoptimize.sort(arr, l, r);
            return;
        }

        int p = partition(arr, l, r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }



    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Algorithm.sortQuick.QuickSort01.QuickSort", arr);
        return;
    }
}
