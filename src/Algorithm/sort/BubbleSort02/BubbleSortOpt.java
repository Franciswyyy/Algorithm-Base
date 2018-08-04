package Algorithm.sort.BubbleSort02;

// 优化： 已经是最大值的就不需要再遍历了
public class BubbleSortOpt {

    private BubbleSortOpt(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n - 1; i ++){
            for(int j = 0; j < n - 1 - i; j ++){
                if(arr[j].compareTo(arr[j + 1]) > 0){
                    swap(arr, j, j + 1);
                }
            }
        }
    }


    private static void swap(Object[] arr, int i, int j){
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
