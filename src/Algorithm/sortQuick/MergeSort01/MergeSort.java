package Algorithm.sortQuick.MergeSort01;

import Algorithm.sortTestHelp.SortTestHelper;

public class MergeSort {

    private MergeSort() {
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge(Comparable[] arr, int l, int mid, int r) {

        //Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        Comparable[] aux = new Comparable[r-l+1];
        //arr从l开始，aux从0开始 全部复制过去
        for(int i = l; i <= r; i ++){
            aux[i-l] = arr[i];
        }

        //初始化，i指向左半部分的起始索引位置1,j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for(int k = l; k <= r; k++){
            if(i > mid){        // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l];
                j ++;
            }else if(j > r){       // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l];
                i ++;
            }else if(aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] = aux[i-l];
                i ++;
            }else {
                arr[k] = aux[j-l];
                j ++;
            }
        }
    }


    //递归使用归并排序，对arr[l..r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r){

        if(l >= r)  return;

        int mid = (r-l)/2 + l;
        sort(arr, l, mid);
        sort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int N = 900000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 900000);
        SortTestHelper.testSort("Algorithm.sortQuick.MergeSort01.MergeSort",arr);

    }
}
