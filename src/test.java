
import java.util.*;

public class test {


    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       while(sc.hasNext()){
           String str = sc.nextLine();
           System.out.println(helper(str));
       }
    }

    public static int helper(String str){
        int back = str.charAt(3)-'0'+str.charAt(5)-'0'+str.charAt(4)-'0';
        int one = str.charAt(0) - '0';
        int two = str.charAt(1) - '0';
        int three = str.charAt(2) - '0';
        int front = one + two + three;



// 错误用例
        if(front == back) return 0;
        int need = back - front;
        int requireMax = Math.max(9-one, Math.max(9-two, 9-three));
        int requireMin = Math.min(9-one, Math.min(9-two, 9-three));
        int requireMid = 27-front-requireMax-requireMin;
        if(requireMax >= need) return 1;

        else if(requireMid + requireMax > need) return 2;
        return 3;
    }

}
