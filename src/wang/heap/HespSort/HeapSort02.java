package wang.heap.HespSort;

import wang.heap.MaxHeap;
import wang.sortTestHelp.SortTestHelper;

// 使用Heapify方式堆排序
public class HeapSort02 {

    private HeapSort02() {
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(arr);
        for( int i = n-1 ; i >= 0 ; i -- )
            arr[i] = maxHeap.extractMax();
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("wang.heap.HespSort.HeapSort02", arr);

        return;
    }
}
