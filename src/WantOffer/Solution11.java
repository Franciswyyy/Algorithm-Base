package WantOffer;

// 斐波那契数列
public class Solution11 {

    public int Fibonacci(int n) {

        if(n <= 0) return 0;
        if(n == 1) return 1;
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 上述的从上到下可能会有很多重复值,时间复杂度为n的指数方式增加的
     * 而这个从下往上计算，先计算时间复杂度为O(n)
     * @param n
     * @return
     */
    public int Fibonacci01(int n){

        int[] res = {0, 1};
        if(n < 2) return res[n];

        int one = 0;
        int two = 1;
        int result = 0;
        for(int i = 2; i <= n; i ++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }
}
