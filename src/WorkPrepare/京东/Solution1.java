package WorkPrepare.京东;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(sc.hasNext()){
            n = sc.nextInt();
            int m = sc.nextInt();
            boolean nums[][] = new boolean[n+1][n+1];
            for(int i = 0; i < m; i ++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                nums[x][y] = true;
                nums[y][x] = true;
            }
           helper(nums, n);
        }
    }
    private static void helper(boolean[][] nums, int n){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        for(int i = 1; i < n+1; i ++){
            if(!nums[1][i]){
                arrayList.add(i);
                hashSet.add(i);
            }
        }
        String flag = "Yes";
        for(int i = 2; i < n+1; i ++){
            if(hashSet.contains(i)) continue;
            for(int j : arrayList){
                if(!nums[i][j])flag = "No";
            }
        }
        System.out.println(flag);
    }
}
