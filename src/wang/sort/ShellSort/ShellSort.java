package wang.sort.ShellSort;

public class ShellSort {

    private ShellSort() {}

    public static void sort(Comparable[] arr){

        int n = arr.length;

        //一般来说 步长以3开始，1, 4, 13, 40, 121, 364, 1093...
        int h = 1;
        while(h < n/3) h = 3 * h + 1;

        while(h >= 1){

            for(int i = h; i < n; i ++){

                /*
                内循环中未优化的插入排序
                for(int j = i; j >= h && (a[j] < a[j-h]); j -= h){
                    swap(a, j, j-h);
                }*/

                // 对 arr[i], arr[i-h], arr[i-2*h], arr[i-3*h]... 使用插入排序
                Comparable e = arr[i];
                int j = i;
                for( ; j >= h && e.compareTo(arr[j-h]) < 0; j -=h ){
                    arr[j] = arr[j-h];
                }
                arr[j] = e;
            }
            h /= 3;
        }
    }

}
