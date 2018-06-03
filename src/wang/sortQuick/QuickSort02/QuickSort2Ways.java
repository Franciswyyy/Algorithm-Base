package wang.sortQuick.QuickSort02;

import wang.sort.InsertionSort02.InsertionSortoptimize;
import wang.sortTestHelp.SortTestHelper;

public class QuickSort2Ways {

    private QuickSort2Ways() {
    }

    private static int partition(Comparable[] arr, int l, int r){

        SortTestHelper.swap(arr, l, (int)(Math.random() *(r-l+1)) + l);
        Comparable e = arr[l];

        int i = l + 1, j = r;
        while(true){
            while( i <= r && arr[i].compareTo(e) < 0) i ++;
            while( j >= l && arr[j].compareTo(e) > 0) j --;

            if(i > j) break;

            SortTestHelper.swap(arr, i, j);
            i ++;
            j --;
        }
        SortTestHelper.swap(arr, l, j);

        return j;
    }


    private static void sort(Comparable[] arr, int l, int r){

        if(r - l <= 15){
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

        // 双路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);
        SortTestHelper.testSort("wang.sortQuick.QuickSort02.QuickSort2Ways", arr);
        //SortTestHelper.printArray(arr);
        return;
    }
}
