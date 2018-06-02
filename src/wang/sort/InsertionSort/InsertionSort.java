package wang.sort.InsertionSort;

import wang.sort.SelectionSort03.SortTestHelper;

public class InsertionSort {

    // 我们的算法类不允许产生任何实例
    private InsertionSort() {
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {

            //寻找arr[i]的最佳插入位置
            for(int j = i; j > 0 && arr[j].compareTo(arr[j-1]) < 0; j --){
                //要是不熟悉泛型的话，直接写arr[i] < arr[j-1]
                swap(arr, j, j-1);
            }

           /*  寻找元素arr[i]合适的插入位置
            for( int j = i ; j > 0 ; j-- )
                if( arr[j] < arr[j-1] )
                    swap( arr， j, j-1 );
                else
                    break;
            */
        }
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试InsertionSort
    public static void main(String[] args) {

       /* Integer[] arr = new Integer[]{4,5,3,8,1,9,2,6,7};
        sort(arr);
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }*/

        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("wang.sort.InsertionSort.InsertionSort", arr);

        return;
    }
}