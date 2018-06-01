package wang.sort.SelectionSort02;


//添加泛型，自定义比较的选择排序
public class SelectionSort {

    // 目的不允许产生实例
    private SelectionSort() {
    }

    public static void selectSort(Comparable[] arr){

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
        //测试Integer
        Integer[] a = {10,9,8,7,6,5,4,3,2,1};
        SelectionSort.selectSort(a);
        for( int i = 0 ; i < a.length ; i ++ ){
            System.out.print(a[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试Double
        Double[] b = {4.4, 3.3, 2.2, 1.1};
        SelectionSort.selectSort(b);
        for( int i = 0 ; i < b.length ; i ++ ){
            System.out.print(b[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试String
        String[] c = {"D", "C", "B", "A"};
        SelectionSort.selectSort(c);
        for( int i = 0 ; i < c.length ; i ++ ){
            System.out.print(c[i]);
            System.out.print(' ');
        }
        System.out.println();

        // 测试自定义的类 Student
        Student[] d = new Student[4];
        d[0] = new Student("D",90);
        d[1] = new Student("C",100);
        d[2] = new Student("B",95);
        d[3] = new Student("A",95);
        SelectionSort.selectSort(d);
        for( int i = 0 ; i < d.length ; i ++ )
            System.out.println(d[i]);
    }

}
