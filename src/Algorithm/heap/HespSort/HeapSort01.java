package Algorithm.heap.HespSort;

import Algorithm.heap.MaxHeap;
import Algorithm.sortTestHelp.SortTestHelper;

// 堆排序， 将数组元素添加到堆中，并取出来
public class HeapSort01 {

    private HeapSort01() {
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);

        for(int i = 0; i < n; i ++){
            maxHeap.insert(arr[i]);
        }

        for(int i = n-1; i >= 0; i --){
            arr[i] = maxHeap.extractMax();
        }
    }

    public static void main(String[] args) {

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        SortTestHelper.testSort("Algorithm.heap.HespSort.HeapSort01", arr);
    }
}
