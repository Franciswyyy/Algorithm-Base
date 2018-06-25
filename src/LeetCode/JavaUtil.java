package LeetCode;

public class JavaUtil {

    // 求最大公约数
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }

    // 判断一个素数
    public static boolean isPrime(int n){
        for(int x = 2; x*x <= n; x ++){
            if(n % x == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int gcd = gcd(6,8);
        System.out.println(8/gcd + "/" + 6/gcd);
    }
}
