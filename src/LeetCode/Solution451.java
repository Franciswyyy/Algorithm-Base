package LeetCode;

import java.util.*;

public class Solution451 {

    // 利用treemap排序
    public String frequencySort(String s) {


        TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
        for(int i = 0; i < s.length(); i ++){
            char s1 = s.charAt(i);
            map.put(s1, map.getOrDefault(s1, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });


        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer>entry : entryList){
            int num = entry.getValue();
            while(num != 0){
                sb.append(entry.getKey());
                num--;
            }
        }
        return String.valueOf(sb);
    }

    // 利用堆排序
    public String frequencySort1(String s){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                }
        );

        pq.addAll(map.entrySet());
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty()){
            Map.Entry e = pq.poll();
            for(int i = 0; i < (int)e.getValue(); i ++){
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
