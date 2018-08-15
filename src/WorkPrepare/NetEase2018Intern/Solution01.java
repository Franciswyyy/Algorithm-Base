package WorkPrepare.NetEase2018Intern;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int job = sc.nextInt();  // 几份工作
            int par = sc.nextInt();  // 几个伙伴
            int[][] jobValue = new int[job][2];
            for(int i = 0; i < job; i ++){
                jobValue[i][0] = sc.nextInt();    // 工作难度
                jobValue[i][1] = sc.nextInt();    // 工作报酬
            }
            int[] pars = new int[par];
            for(int i = 0; i < par; i ++){
                pars[i] = sc.nextInt();
            }

           helper(jobValue, pars);

        }
    }

    // 暴力过40
    private static void helper(int[][] nums, int[] ability){
        // 找比其能力小于或者等于里的最大报酬
        int[] res = new int[ability.length];
        Arrays.sort(nums, (a, b) -> (a[0] - b[0]));  // 按照难度从小到大排

        for(int i = 0; i < ability.length; i ++){
            int work = ability[i];
            int tmp = 0;
            for(int j = 0; j < nums.length; j++){
                if(nums[j][0] <= work){
                    tmp = Math.max(tmp, nums[j][1]);
                }else {
                    break;
                }
            }
            res[i] = tmp;
        }
        for(int i = 0; i < res.length; i ++){
            System.out.println(res[i]);
        }
    }

    // 二分查找全过
    private static void helper1(int[][] jobArray, int[] ability){

        Arrays.sort(jobArray, (int[] jd1, int[] jd2) -> (jd1[0] - jd2[0]));   //按照工作难度从小到大


        // 把每个工作酬劳更新为当前难度最大的报酬，就不会出现1个劳动力10元，而10个劳动力1元了。
        // [1 10][2 8]为 [1 10][2 10]
        for(int i = 0; i < jobArray.length-1; i ++){
            if(jobArray[i][1] > jobArray[i+1][1]){
                jobArray[i+1][1] = jobArray[i][1];
            }
        }


        //二分查找，最大的工作以及最大的报酬
        for(int i = 0; i < ability.length; i ++){
            int begin = 0;
            int end = jobArray.length-1;

            int max = 0;
            while(begin <= end){
                int mid = (end - begin)/2 + begin;
                if(ability[i] >= jobArray[mid][0]){
                    max = jobArray[mid][1];
                    begin = mid+1;
                }else {
                    end = mid-1;
                }
            }
            System.out.println(max);
        }

    }

    // map方法全过
    private static void helper2(int[][] jobArray, int[] ability){

        Arrays.sort(jobArray, (int[] jd1, int[] jd2) -> (jd1[0] - jd2[0]));   //按照工作难度从小到大
        TreeMap<Integer, Integer>map = new TreeMap<>();

        // 把每个工作酬劳更新为当前难度最大的报酬，就不会出现1个劳动力10元，而10个劳动力1元了。
        // [1 10][2 8]为 [1 10][2 10]
        for(int i = 1; i < jobArray.length; i ++){
           if(jobArray[i-1][1] > jobArray[i][1]){
               jobArray[i][1] = jobArray[i-1][1];
           }
            map.put(jobArray[i-1][0], jobArray[i-1][1]);
        }
        int len = jobArray.length;
        map.put(jobArray[len-1][0], jobArray[len-1][1]);

        //通过对应的API就可以求出来了
        for(int i = 0; i < ability.length; i ++){
            Integer index = map.floorKey(ability[i]);  //小于等于key里的最大的键
            if(index != null){
                System.out.println(map.get(index));
            }else{
                System.out.println(0);
            }
        }
    }
}
