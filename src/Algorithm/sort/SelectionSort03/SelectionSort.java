package Algorithm.sort.SelectionSort03;


import Algorithm.sortTestHelp.SortTestHelper;

// 优化后的选择排序    ----   每一趟中， 可以同时找到当前未处理元素的最大值和最小值
public class SelectionSort {

    // 目的不允许产生实例
    private SelectionSort() {
    }
    public static void sort(Comparable[] arr){

       int left = 0, right = arr.length - 1;

       while(left < right){
           int minIndex = left;
           int maxIndex = right;

           if(arr[minIndex].compareTo(arr[maxIndex]) > 0){
               swap(arr, minIndex, maxIndex);
           }

           for(int i = left + 1 ; i < right; i ++)
               if(arr[i].compareTo(arr[minIndex]) < 0)
                   minIndex = i;
               else if(arr[i].compareTo(arr[maxIndex]) > 0)
                   maxIndex = i;

           swap(arr, left, minIndex);
           swap(arr, right, maxIndex);

           left ++;
           right --;
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
        SortTestHelper.testSort("Algorithm.sort.SelectionSort03.SelectionSort", arr);
        return;
    }



}
