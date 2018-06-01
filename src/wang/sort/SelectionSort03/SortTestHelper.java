package wang.sort.SelectionSort03;

// 一般用于测试用例， 比如 打印数组，生成随机数组，
public class SortTestHelper {

    // SortTestHelper不允许产生任何实例
    private SortTestHelper(){}

    //生成有n个元素的随机数组，每个元素的随机范围为[rangL, rangR]
    public static Integer[] generateRandomArray(int n, int rangL, int rangR){

        assert rangL <= rangR;

        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i ++){
            arr[i] = new Integer((int)(Math.random() * (rangR- rangL + 1) + rangL));
        }
        return arr;
    }

   //打印arr数组的所有内容
    public static void printArray(Object arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.print( arr[i] );
            System.out.print( ' ' );
        }
        System.out.println();

        return;
    }
}
