import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

public class JavaUtil02 {

   //tree map从value从小到大排序
    //正常情况下Map是不可以使用Collections.sort()方法进行排序的，不过可以将Map转换成list之后再进行排序。
    public static void treeMapTest02(){
        Map<String, String> map = new TreeMap<String, String>();
        map.put("b", "ccccc");
        map.put("d", "bbbbb");
        map.put("c", "aaaaa");
        map.put("a", "ddddd");
        List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
        //然后通过比较器来实现排序
        Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
            //升序排序
            public int compare(Map.Entry<String, String> o1,
                               Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }

        });

        for(Map.Entry<String,String> mapping:list){
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }


    }

    //tree map认是key从小到大
    public static void treeMapTest01(){
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1); // key从大到小。
//                        return o1.compareTo(o2);  key从大到小的
                    }
                }
        );
        map.put("b", "ccccc");
        map.put("d", "bbbbb");
        map.put("c", "aaaaa");
        map.put("a", "ddddd");
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String,String> entry = iter.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }



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
//        BinaryTest();
//        treeMapTest();
        treeMapTest02();
    }

}
