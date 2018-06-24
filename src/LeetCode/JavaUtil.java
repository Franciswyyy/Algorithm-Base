package LeetCode;

public class JavaUtil {

    // 求最大公约数
    public static int gcd(int x, int y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }

    public static void main(String[] args) {
        int gcd = gcd(6,8);
        System.out.println(8/gcd + "/" + 6/gcd);
    }
}
