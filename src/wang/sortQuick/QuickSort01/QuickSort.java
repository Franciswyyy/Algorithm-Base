package wang.sortQuick.QuickSort01;

import wang.sortTestHelp.SortTestHelper;

public class QuickSort {

    private QuickSort() {
    }

    private static int partition(Comparable[] arr, int l, int r){

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

        if(l >= r) return;

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
        SortTestHelper.testSort("wang.sortQuick.QuickSort01.QuickSort", arr);
        return;
    }
}
