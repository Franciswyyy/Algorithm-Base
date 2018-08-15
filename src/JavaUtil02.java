import java.util.*;

public class JavaUtil02 {

    // 二分查找
    public static void BinaryTest(){
        int arr[] = {17, 40, 12, 6, 15, 16, 8, 10, 18, 50};

        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int index = Arrays.binarySearch(arr, 12);
        if (index >= 0) {
            System.out.println(12 + "是数组的第" + (index + 1) + "位元素");
        } else {
            System.out.println(12 + "不是数组的元素");
        }

    }

    // treeMap测试
    public static void TreeMapTest(){

        TreeMap<Integer, Integer> treemap = new TreeMap<>();
        treemap.put(1,3);
        treemap.put(3,2);
        treemap.put(5,6);
        treemap.put(2,4);
        treemap.put(4,5);

        // 遍历一遍，默认从小到大
        Iterator<Map.Entry<Integer,Integer>> iter = treemap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Integer> entry = iter.next();
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

        System.out.println("----测试方法----");
        // first默认是最小的
        System.out.println("key:" + treemap.firstEntry().getKey() + " value:" + treemap.firstEntry().getValue());
        // last默认是最大的
        System.out.println("key:" + treemap.lastEntry().getKey() + " value:" + treemap.lastEntry().getValue());


        System.out.println("----测试比较器----");

        /*
        这就是默认的这种，按照key的从小到大排
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer,Integer>(
                (Integer o1, Integer o2) -> (o1 .compareTo(o2)));
        */

        /*
        按照key的从大到小排
        TreeMap<Integer, Integer> map1 = new TreeMap<Integer,Integer>(
                (Integer o1, Integer o2) -> (o2 .compareTo(o1)));
        */


    }


    public static void main(String[] args) {
//        TreeMapTest();
        BinaryTest();
    }

}
