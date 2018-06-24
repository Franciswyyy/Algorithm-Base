package LeetCode;

import java.util.*;

public class Solution049 {

    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String keyStr = String.valueOf(c);
            if(!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<String>());  // 不存在创建一个对应的key
            map.get(keyStr).add(s);    // 存在的话就直接放进去
        }
        return new ArrayList<List<String>>(map.values());
    }


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap();
        map.put(1, "wang");
        map.put(2, "yu");
        map.put(3,"wnagyu");
        List<String> list = new ArrayList<>(map.values());
        Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.print(iter.next());
        }
        System.out.println();
        String[] arr = new String[map.size()];
        map.values().toArray(arr);
        for(int i = 0; i < arr.length; i ++){
            System.out.print(arr[i]);
        }
    }
}
