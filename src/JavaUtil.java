
import java.util.*;
import java.util.stream.Collectors;

public class JavaUtil {

    //用递归求一个n个数的和
    public static int AddRecursive(int n){
        return n < 0 ? 0 : n + AddRecursive(n-1);
    }


    // map的操作
    public static void hashMap(HashMap<Integer,Integer> map){

        // 遍历方式一
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
        }

        // 遍历方式二
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
        }


    }



    // lambda表达式
    public static void lambda(){

        // 输出遍历
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        List<String> list = Arrays.asList("a", "b", "c", "d");
        list.forEach(System.out :: println);
        list.forEach((s) -> System.out.println("!"+s+"~"));    //对参数进行修改

        // 过滤
        List<String> filter = list.stream()
                .filter((x) -> x.length()>2)
                .collect(Collectors.toList());
    }




    //一维，二维数组大小排序
    public static void ArraySort(Integer[] arr, int[][] nums){

        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));    //按照第一个元素从小到大
        Arrays.sort(nums, (a, b) -> (a[1] - b[1]));    // 按照第二个元素从小打大


        Arrays.sort(arr, ((a,b) -> (a.compareTo(b))));   // 从小到大
        Arrays.sort(arr, ((a,b) -> (b.compareTo(a))));  // 从大到小


    }
    private static void print(Integer[] arr){
        for(int a : arr) System.out.print(a + " ");
        System.out.println();
    }
    private static void print(int[][] arr){
        for(int i = 0; i < arr.length; i ++){
            for(int j = 0; j  < arr[0].length; j ++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }


    //判断字母是大小写
    public static void UppserOrLower(String str){
        StringBuffer upper = new StringBuffer();
        StringBuffer lower = new StringBuffer();

        for(int i = 0; i < str.length(); i ++){
            Character c = str.charAt(i);
            if(Character.isUpperCase(c)){
                upper.append(c);
            }else if(Character.isLowerCase(c)){
                lower.append(c);
            }
        }
        System.out.println("大写字母：" + upper);
        System.out.println("小写字母：" + lower);
    }

    // 最小堆写法以及最大堆
    public static void priority(){

        // 默认的priorityQueue,底层是最小堆
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i = 0; i < 10; i ++){
            int num = (int)(Math.random() * 100);
            pq.add(num);
            System.out.println("插入优先队列中："+num);
        }

        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " | ");
        }
        System.out.println();


        // 使用lambda表达式，创建底层是最大堆的PriorityQueue
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(10, (a, b) -> b - a);

        for(int i = 0 ; i < 10 ; i ++){
            int num = (int)(Math.random() * 100);
            pq2.add(num);
            System.out.println("插入优先队列中："+num);
        }

        while (!pq2.isEmpty())
            System.out.print(pq2.poll() + " ");



        // 使用自定义的Comparator，创建个性化的PriorityQueue
        // 注意：也可以使用lambda表达式。在这里只是为了演示PriorityQueue的不同用法
        // 同理，上一个例子也可以使用自定义的Comparator的方式完成
        class myCmp implements Comparator<Integer> {
            @Override
            public int compare(Integer a, Integer b){
                if(a%10 != b%10)
                    return a%10 - b%10;
                return a - b;
            }
        }
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>(10, new myCmp());

        for(int i = 0 ; i < 10 ; i ++){
            int num = (int)(Math.random() * 100);
            pq3.add(num);
            System.out.println("insert " + num + " in priority queue.");
        }

        while (!pq3.isEmpty())
            System.out.print(pq3.poll() + " ");

        System.out.println();
    }


    // 求最大公约数
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }

    // 判断一个素数
    public static boolean isPrime(int n){
        for(int x = 2; x*x <= n; x ++){
            if(n % x == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        priority();
//        UppserOrLower("ASFdjfkGMCHIEjfdkasGHDH");
        Integer[] arr = new Integer[]{4,2,5,1,7,6};
        int[][] num = new int[][]{{1,4},{3,6},{2,3},{6,2}};
        ArraySort(arr, num);
    }
}
