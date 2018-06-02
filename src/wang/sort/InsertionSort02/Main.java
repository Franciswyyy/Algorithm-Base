package wang.sort.InsertionSort02;

import wang.sortTestHelp.SortTestHelper;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int N = 10000;

        //一般测试
        System.out.println("Test for random array, size = " + N + " , random range [0, " + N + "]");

        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("wang.sort.InsertionSort01.InsertionSort", arr1);  //原始插入
        SortTestHelper.testSort("wang.sort.InsertionSort02.InsertionSortoptimize", arr2);    //优化后插入
        SortTestHelper.testSort("wang.sort.SelectionSort03.SelectionSort",arr3);   //选择排序

        // 测试2 有序性更强的测试
        System.out.println("\r\n"+"Test for more ordered random array, size = " + N + " , random range [0,3]");

        arr1 = SortTestHelper.generateRandomArray(N, 0, 3);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("wang.sort.InsertionSort01.InsertionSort", arr1);  //原始插入
        SortTestHelper.testSort("wang.sort.InsertionSort02.InsertionSortoptimize", arr2);    //优化后插入
        SortTestHelper.testSort("wang.sort.SelectionSort03.SelectionSort",arr3);   //选择排序
        System.out.println();


        // 测试3 测试近乎有序的数组
        int swapTimes = 100;
        System.out.println("Test for nearly ordered array, size = " + N + " , swap time = " + swapTimes);

        arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
        arr2 = Arrays.copyOf(arr1, arr1.length);
        arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("wang.sort.InsertionSort01.InsertionSort", arr1);  //原始插入
        SortTestHelper.testSort("wang.sort.InsertionSort02.InsertionSortoptimize", arr2);    //优化后插入
        SortTestHelper.testSort("wang.sort.SelectionSort03.SelectionSort",arr3);   //选择排序
    }
}
