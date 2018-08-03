package LeetCode;

public class Solution718 {

    public static int findLength(int[] A, int[] B) {

        int m = A.length;
        int n = B.length;
        int[][] dp = new int[m+1][n+1];

        int res = 0;
        for(int i = 0; i <= m; i ++){
            for(int j = 0; j <= n; j ++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                    continue;
                }
                if(A[i-1] == B[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }


    public static int find(int[] A, int[] B){
        int m = A.length;
        int n = B.length;

        int[] dp = new int[n+1];
        int res = 0;
        for(int i = 1; i <= m; i++){
            for(int j = n; j > 0; j --){
                if(A[i-1] == B[j-1]){
                    dp[j] = dp[j-1] + 1;
                    res = Math.max(res, dp[j]);
                }else {
                    dp[j] = 0;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] A = {1,2,3,2,1};
//        int[] B = {3,2,1,4,7};

        int[] A = {1,0,0,1,1};
        int[] B = {1,0,0,0,1};

        System.out.println(find(A,B));
    }
}
