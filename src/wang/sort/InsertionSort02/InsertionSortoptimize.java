package wang.sort.InsertionSort02;


// 优化后的插入排序
public class InsertionSortoptimize {

    // 不产生任何实例
    private InsertionSortoptimize(){}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 1; i < n; i ++){
            Comparable e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1].compareTo(e) > 0; j --){
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }
}
