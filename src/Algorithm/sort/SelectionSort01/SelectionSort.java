package Algorithm.sort.SelectionSort01;


//写一个最基本的选择排序算法
public class SelectionSort {

    //该算法类不产生任何实例
    private SelectionSort() {
    }

    public static void selectSort(int[] arr){

        int len = arr.length;
        for(int i = 0; i < len; i ++){
            int minIndex = i;
            for(int j = i + 1; j < len; j ++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        selectSort(arr);

        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i] + " ");
        }
    }
}
