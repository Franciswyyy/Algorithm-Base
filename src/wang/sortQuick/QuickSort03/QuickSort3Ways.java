package wang.sortQuick.QuickSort03;

import wang.sort.InsertionSort01.InsertionSort;
import wang.sort.InsertionSort02.InsertionSortoptimize;
import wang.sortTestHelp.SortTestHelper;

public class QuickSort3Ways {

    private QuickSort3Ways() {
    }

    private static void sort(Comparable[] arr, int l, int r){

        if( r - l <= 15){
            InsertionSortoptimize.sort(arr, l, r);
            return;
        }

        SortTestHelper.swap(arr, l, (int)(Math.random()*(r-l+1)) + l);
        Comparable v = arr[l];

        int lt = l;
        int gt = r+1;
        int i = l + 1;
        while(i < gt){
            if(arr[i].compareTo(v) < 0){
                SortTestHelper.swap(arr, i, lt+1);
                lt ++;
                i ++;
            } else if(arr[i].compareTo(v) > 0){
                SortTestHelper.swap(arr, gt-1, i);
                gt --;
            }else {
                i ++;
            }
        }
        SortTestHelper.swap(arr, l, lt);

        sort(arr, l, lt-1);
        sort(arr, gt, r);

    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }


    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 200);
        SortTestHelper.testSort("wang.sortQuick.QuickSort03.QuickSort3Ways", arr);
        SortTestHelper.printArray(arr);
        return;
    }
}
