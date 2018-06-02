package wang.sort.SelectionSort03;


import wang.sort.SelectionSort02.Student;
import wang.sortTestHelp.SortTestHelper;

// 用于测试算法的辅助函数
public class SelectionSort {

    // 目的不允许产生实例
    private SelectionSort() {
    }

    public static void sort(Comparable[] arr){

        int len = arr.length;
        for(int i = 0; i < len; i ++){
            int minIndex = i;
            for(int j = i + 1; j < len; j ++){
                if(arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        /*SelectionSort.selectSort(arr);
        SortTestHelper.printArray(arr);*/
        //直接用方法直接调用
        SortTestHelper.testSort("wang.sort.SelectionSort03.SelectionSort", arr);
        return;
    }



}
