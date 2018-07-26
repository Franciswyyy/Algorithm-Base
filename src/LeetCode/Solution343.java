package LeetCode;

import java.util.Arrays;

public class Solution343 {

    int[] memo;

    public int integerBreak(int n) {
        memo = new int[n + 1];

        Arrays.fill(memo, -1);
//        for(int i = 0; i <= n; i++){
//            memo[i] = -1;
//        }
        assert (n >=2 );
        return breakInteger(n);
    }

    private int breakInteger(int n){

        // 当n为1，肯定就不能分解了，这也是递归终止条件
        if(n == 1)
            return 1;

        if(memo[n] != -1){
            return memo[n];
        }

        int res = -1;
        for(int i = 1; i <= n-1; i ++){
            // i + n-i  要注意break函数时一定要分割两部分，但要是就只分两部分呢
            res = max3(res, i * (n-i) , i * breakInteger(n-i));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int a, int b, int c){
        return Math.max(a, Math.max(b,c));
    }


    // 上述是记忆化搜索问题， 下面是动态规划

    public int IntegerBreak(int n){
        assert (n >= 2);

        int[] memo = new int[n+1];

        memo[1] = 1;
        for(int i = 2; i <= n; i ++){
            //求memo[i]
            // 里面循环是对i进行分割
            for(int j = 1; j <= i-1; j ++){
                // j, i-j 或者 j和i-j的切分
                memo[i] = max3(memo[i], j*(i-j), j*memo[i-j]);
            }
        }
        return memo[n];
    }

}
