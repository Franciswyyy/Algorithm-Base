package LeetCode;


// 动态规划入门
public class Dynamic {

    // 动态规划
    public static int fun3(int n){
        int[] memo = new int[n+1];

        memo[0] = 0;
        memo[1] = 1;
        for(int i = 2; i <= n; i ++){
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }



    static int[] memo;
    public static int fun2(int n){

        if(n == 1){
            return 1;
        }

        if(n == 0){
            return 0;
        }

        if(memo[n] == 0){
            memo[n] = fun2(n-1) + fun2(n-2);
        }

        return memo[n];
    }


    //最原始的斐波那契数列    40 --- 1493
    public static int fun1(int n){

        if(n == 1){
            return  1;
        }

        if(n == 0){
            return 0;
        }

        return fun1(n-1) + fun1(n-2);
    }


    public static void main(String[] args) {

        int n = 40;

        memo = new int[n+1];

        long start = System.currentTimeMillis();
        System.out.println(fun3(n));
        long end = System.currentTimeMillis();
        long time = end-start;
        System.out.println("总花费：" + time);

    }
}
