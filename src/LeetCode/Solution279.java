package LeetCode;



import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution279 {

    // Pair类，配对，类似属于Key,Value的整数对。
    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0) return step;

            for(int i = 1; num - i*i >= 0; i ++){
                int a = num - i*i;
                if(!visited[a]){
                    if(a == 0) return step + 1;
                    queue.addLast(new Pair<Integer, Integer>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw  new IllegalStateException("No Solution");
    }

    // 记忆化搜索

    public static int numSquare(int n){
        int[] record = new int[n+1];
        Arrays.fill(record, -1);

        return findMin(n , record);
    }


    private static int findMin(int n, int[] record){

        int k = Squre(n);
        if(n == k *k)
            return 1;

        int res = Integer.MAX_VALUE;
        for(int i = 1; i * i <= n; i ++){
            if(record[n-i*i] == -1){
                record[n- i * i] = findMin(n-i*i, record);
            }
            res = Math.min(res, record[n - i*i] + 1);
        }
        return res;
    }

    private static int Squre(int n){
        int i = 1;
        while(i * i <= n){
            i++;
        }
        return i-1;
    }

    public static void main(String[] args) {
        System.out.println(numSquare(12));
    }


    // 动态规划
    public int numSquaresDP(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;   // 从1开始
        for(int i = 2; i <= n; i ++){
            int min = Integer.MAX_VALUE;
            for(int j = 1; j *j <= i; j ++){
                min = Math.min(min, dp[i-j*j]+1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    //动态规划2
    public int numSquaresDP2(int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        for (int i = 1; i <= n; i ++){
            int min = Integer.MAX_VALUE;
            int j = 1;
            while(i - j * j >= 0){
                min = Math.min(min, dp[i-j*j]+1);
                ++j;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
