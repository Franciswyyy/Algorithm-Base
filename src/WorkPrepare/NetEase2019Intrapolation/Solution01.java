package WorkPrepare.NetEase2019Intrapolation;
// 网易2018内推

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Solution01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();   // 列
            int m = sc.nextInt();   // 玩了多少个
            int[] nums = new int[m];
            for(int i = 0; i < m; i ++){
                nums[i] = sc.nextInt();
            }

            System.out.println(helper(nums, n));
        }
    }

    public static int helper(int[] nums, int cols){
        if(nums.length < cols) return 0;

        HashMap<Integer, Integer>map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        if(map.size() < cols) return 0;    //用的很多。因为上述是有的话就加1，所有并不是每一列都有值。只会在有值里选择最小的那个数。

        int res = Integer.MAX_VALUE;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while(iterator.hasNext()){
            res = Math.min(iterator.next().getValue(), res);
        }
        return res;
    }
}
