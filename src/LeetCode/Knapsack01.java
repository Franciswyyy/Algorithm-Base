package LeetCode;

// 0 1 背包问题
public class Knapsack01 {


    public int knapsack01(int[] w, int[] v, int c){
        if(w == null || v == null || w.length != v.length)
            throw new IllegalArgumentException("Invalid w or v");

        int n = w.length;
        int[][] memo = new int[n][c+1];

        return bestValue(w, v, n-1,c, memo);
    }

    // 用[0..index]的物品，填充容量为c的背包最大价值
    private int bestValue(int[] w, int[] v, int index, int c, int[][] memo){

        if(c <= 0 || index < 0)
            return 0;

        if(memo[index][c] != -1)
            return memo[index][c];

        int res = bestValue(w, v, index-1, c, memo);
        if(c >= w[index])
            res = Math.max(res, v[index] + bestValue(w, v, index-1, c-w[index], memo));
        memo[index][c] = res;
        return res;
    }


    // 上述自顶向下的记忆化搜索，动态规划


    public int knapsack01A(int[] w, int[] v, int c){

        if(w == null || v == null || w.length != v.length){
            return 0;
        }

        int n = w.length;
        if( n == 0) return 0;
        int[][] memo = new int[n][c+1];

        for(int i = 0; i <= c; i ++)
            memo[0][i] = (i >= w[0] ? v[0] : 0);

        for(int i = 1;  i < n; i ++ ){
            for(int j = 0; j <= c; j ++){
                memo[i][j] = memo[i-1][j];
                if( j >= w[i])
                    memo[i][j] = Math.max(memo[i][j], v[i] + memo[i-1][j-w[i]]);
            }
        }
        return memo[n-1][c];
    }

    // 压缩空间后的背包问题

    public int knapsack01B(int[] w, int[] v, int c) {

        int n = w.length;
        if(n == 0 || c == 0) return 0;

        int[] memo = new int[c+1];

        for(int i = 0; i <= c; i ++)
            memo[i] = (i >= w[0] ? v[0] : 0);

        for(int i = 1; i < n; i ++){
            // 从后往前遍历
            for(int j = c; j >= w[i]; j --)
                memo[j] = Math.max(memo[j], memo[j - w[i]]);
        }
        return memo[c];
    }

}
