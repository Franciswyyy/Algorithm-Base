package WorkPrepare.京东;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
         int n =  sc.nextInt();
         int[][] nums = new int[n][3];
         for(int i = 0; i < n; i ++){
             for(int j = 0; j < 3; j ++){
                 nums[i][j] = sc.nextInt();
             }
         }
            System.out.println(helper(nums));
        }

    }

    private static int helper(int[][] nums){
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < nums.length; j ++){
                if(nums[i][0] > nums[j][0] && nums[i][1] > nums[j][1] && nums[i][2] > nums[j][2]){
                    set.add(j);
                }
            }
        }
        return set.size();
    }
}
