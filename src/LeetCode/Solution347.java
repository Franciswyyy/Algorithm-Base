package LeetCode;

import java.util.*;

public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length < k) return res;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }


        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>
                ((a, b) -> (b.getValue() - a.getValue()));
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(entry);
        }


        while(res.size() < k){
            Map.Entry<Integer, Integer>entry = pq.poll();
            res.add(entry.getKey());
        }
        return res;
    }
}
