package wang.sort.BubbleSort01;

import wang.sortTestHelp.SortTestHelper;

import java.util.Arrays;

// 最基本的冒泡排序
public class BubbleSort {

    private BubbleSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n-1; i ++){
            for(int j = i + 1; j < n; j ++){
                if(arr[i].compareTo(arr[j]) > 0)
                    swap(arr, i, j);
            }
        }
    }


    private static void swap(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int N = 40000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 40000);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("wang.sort.BubbleSort01.BubbleSort", arr);


        SortTestHelper.testSort("wang.sort.BubbleSort02.BubbleSortOpt",arr1);

        return;
    }
}
