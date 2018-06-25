package LeetCode;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.HashMap;

public class Solution149 {
    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }


    // 通过率  99%   可能是精度的问题
    public static int maxPoints(Point[] points) {
        if(points == null) return 0;
        if(points.length <= 2) return points.length;


        int res = 0;    // 最多的节点
        for(int i = 0; i < points.length; i ++){

            HashMap<Double, Integer> map = new HashMap<>();
            int sameXPoint = 1;
            int samePoint = 0;


            for(int j = 0; j < points.length; j ++){
                if(i == j) continue;


                int y = points[i].y - points[j].y;
                int x = points[i].x - points[j].x;


                if(x == 0 && y == 0){   // 点重合了
                    ++samePoint;
                }
                if(x == 0){
                    ++sameXPoint;
                    continue;
                }

                double ratio = (double)y/(double)x;
                if(map.containsKey(ratio)){
                    map.put(ratio, map.get(ratio) + 1);
                }else {
                    map.put(ratio, 2);
                }
                res =  Math.max(res, map.get(ratio) + samePoint);
            }
            res = Math.max(res, sameXPoint);

        }
        return res;
    }

}



