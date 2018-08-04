package Algorithm.sortQuick.MergeSort03BU;

import Algorithm.sort.InsertionSort02.InsertionSortoptimize;
import Algorithm.sortTestHelp.SortTestHelper;

import java.util.Arrays;

public class MergeSortBU {

    private MergeSortBU() {
    }

    private static void merge(Comparable[] arr, int l, int mid, int r){

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = aux[j-l];
                j ++;
            }else if(j > r){
                arr[k] = aux[i-l];
                i ++;
            }else if(aux[i-l].compareTo(aux[j-l]) > 0){
                arr[k] = aux[j-l];
                j ++;
            }else {
                arr[k] = aux[i - l];
                i ++;
            }
        }
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;

       /* for(int sz = 1; sz < n; sz *= 2){
            for(int i = 0; i + sz < n; i += sz+sz){
                // 对 arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1] 进行归并
                merge(arr, i, i + sz -1, Math.min(i + 2*sz - 1, n - 1));
            }
        }*/


        // Merge Sort Bottom Up 优化
        // 对于小数组, 使用插入排序优化
        for( int i = 0 ; i < n ; i += 16 )
            InsertionSortoptimize.sort(arr, i, Math.min(i+15, n-1) );

        for( int sz = 16; sz < n ; sz += sz )
            for( int i = 0 ; i < n - sz ; i += sz+sz )
                // 对于arr[mid] <= arr[mid+1]的情况,不进行merge
                if( arr[i+sz-1].compareTo(arr[i+sz]) > 0 )
                    merge(arr, i, i+sz-1, Math.min(i+sz+sz-1,n-1) );

    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Algorithm.sortQuick.MergeSort03BU.MergeSortBU", arr);

        return;
    }
}
