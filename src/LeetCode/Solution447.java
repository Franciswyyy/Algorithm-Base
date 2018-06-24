package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Solution447 {

    public int numberOfBoomerangs(int[][] points) {

        if(points == null || points.length == 0) return 0;

        int res = 0;
        for(int i  = 0; i < points.length; i ++){    // 每个点都记录一张查找表

            Map<Integer, Integer> map = new HashMap<>();      // 查找表记录的是距离，距离出现的频率
            for(int j = 0; j < points.length; j ++){
                if(i == j) continue;

                int dist = dist(points[i], points[j]);
                map.put(dist, map.getOrDefault(dist, 0 ) + 1);
            }

            for(Map.Entry<Integer, Integer>entry : map.entrySet()){
                if(entry.getValue() >= 2){    // 当为1 直接为0, 可以直接省略
                    res += entry.getValue() * (entry.getValue() - 1);
                }
            }
        }
        return res;
    }

    public int dist(int[] A, int[] B){
         int x = A[0] - B[0];
         int y = A[1] - B[1];
         return x * x + y * y;
    }
}
