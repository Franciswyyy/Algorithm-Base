package WorkPrepare.NetEase2019Intrapolation;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Solution06 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           int n = sc.nextInt();  //几个数
           int k = sc.nextInt(); // 最多操作几次
           int[] data = new int[n];
           for(int i = 0; i < n; i ++){
               data[i] = sc.nextInt();
           }
            helper(data, k);
        }
    }
    private static void helper(int[] nums, int max){
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        // 编号
        for(int i = 0; i < nums.length; i ++){
            map.put(i+1, nums[i]);
        }

        // 按照value升序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            //升序排序
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        List<int[]> res = new ArrayList<>();
        int count = 0;
        int max_index;
        int min_index;
        while(list.get(0).getValue() -1 >= list.get(list.size()-1).getValue() + 1 && count + 1 <= max){
            max_index = list.get(0).getKey();
            min_index = list.get(list.size()-1).getKey();
            list.get(0).setValue( list.get(0).getValue() -1) ;  //从最多的一个搬走一个。
            list.get(list.size()-1).setValue(list.get(list.size()-1).getValue() + 1);
            count ++;
            res.add(new int[]{max_index, min_index});

            Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
                //升序排序
                public int compare(Map.Entry<Integer, Integer> o1,
                                   Map.Entry<Integer, Integer> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });
        }

        int minValue = list.get(0).getKey() - list.get(list.size()-1).getKey();
        System.out.println(minValue + " " + count);
        //输出
        Iterator<int[]> iterator = res.iterator();
        while(iterator.hasNext()){
            int[] tmp= iterator.next();
            System.out.println(tmp[0] + " " + tmp[1]);
        }
    }


}
