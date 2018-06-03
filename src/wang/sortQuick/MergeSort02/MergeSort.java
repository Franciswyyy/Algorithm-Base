package wang.sortQuick.MergeSort02;

import wang.sort.InsertionSort02.InsertionSortoptimize;
import wang.sortTestHelp.SortTestHelper;

import java.util.Arrays;

public class MergeSort {

    private MergeSort() {
    }

    private static void merge(Comparable[] arr, int l, int mid, int r){

        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid + 1;
        for(int k = l; k <= r; k ++){

            if(i > mid){
                arr[k] = aux[j-l];
                j++;
            }
            else if(j > r){
                arr[k] = aux[i-l];
                i++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] = aux[i-l];
                i++;
            }else{
                arr[k] = aux[j-l];
                j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r){
        // 优化1，小规模用插入
        if( r - l <= 15){
            InsertionSortoptimize.sort(arr, l, r);
            return;
        }

        int mid = (r-l)/2 + l;
        sort(arr, l, mid);
        sort(arr, mid+1, r);

        // 优化2，对于已经有序不进行merger
        if(arr[mid].compareTo(arr[mid+1]) > 0){
            merge(arr, l, mid, r);
        }

    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n-1);
    }

    public static void main(String[] args) {

        int N = 900000;

        // 测试1 一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("wang.sortQuick.MergeSort01.MergeSort", arr1);
        System.out.println("----优化后-----");
        SortTestHelper.testSort("wang.sortQuick.MergeSort02.MergeSort", arr2);

        System.out.println();
    }
}
