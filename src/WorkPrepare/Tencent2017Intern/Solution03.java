package WorkPrepare.Tencent2017Intern;


import java.util.*;


/*
    n个数组成二元组，相差最大，最小的依次有多少？
 */

public class Solution03 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; i ++){
                nums[i] = sc.nextInt();
            }
            int[] res = helper(nums);
            System.out.println(res[0]+ " " + res[1]);
        }
    }

    // 暴力解，通过10
    private static int[] helper(int[] nums){

        Arrays.sort(nums);

        int len = nums.length;
        int max = nums[len-1] - nums[0];
        int min = Integer.MAX_VALUE;
        int maxNum = 0;
        int minNum = 0;

        for(int i = 0; i < len-1; i ++){
            for(int j = i+1; j < len; j++){
                if(nums[j] - nums[i] < min){
                    min = nums[j] - nums[i];
                    minNum = 1;
                }else if(nums[j] - nums[i] == min){
                    minNum ++;
                }else if(nums[j] - nums[i] == max){
                    maxNum++;
                }
            }
        }
        return new int[]{minNum, maxNum};
    }

    private static int[] helper1(int[] nums){

        Arrays.sort(nums);
        int len = nums.length;

        //1. 如果每个数都相同，两两组合
        if(nums[0] == nums[len-1]){
            int res = (len * (len-1))/2;
            return new int[]{res, res};
        }

        //2. 不是每个都相同的,那么就得每个都统计了
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i < len; i ++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        //2.1 求最小的，分有重复的和没重复的。
        int minRes = 0;
        // TreeMap只是个辅助的，为什么想着要一定用它呢？只有有重复的才会用用到treemap
        if(map.size() == len){   // 思路很好，只要不相等就是有重复的。不重复的最小值就是相邻的值
            int min = nums[1] - nums[0];
            minRes++;
            for(int i = 2; i < len; i ++){
                int tmp = nums[i] - nums[i-1];
                if(tmp == min){
                    minRes++;
                }else if(tmp < min){
                    minRes = 1;
                    min = tmp;
                }
            }
        }else{
            for(Integer key : map.keySet()){     // 遍历map的value
                int val = map.get(key);
                if(val > 1){
                    minRes += (val*(val-1))/2;
                }
            }
        }


        //2.2 求最大的
        int maxRes = (map.lastEntry().getValue()) * (map.firstEntry().getValue());

        return new int[]{minRes, maxRes};
    }
}
