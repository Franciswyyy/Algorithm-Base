package WorkPrepare.huawei2019;

import java.math.BigDecimal;
import java.util.Scanner;

public class Solution01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
           int num = sc.nextInt();
           double price = sc.nextDouble();
           if(fun1(num,price) > fun2(num, price)) System.out.println(2);
           else if(fun1(num,price) < fun2(num, price)) System.out.println(1);
           else System.out.println(0);

        }

    }

    private static double fun1(int num, double price){
        double sum = num * price;
        if(num >= 3) sum = sum * 0.7;
        if(sum >= 50) return sum;
        else return sum+10;
    }
    private static double fun2(int num, double price){
        double sum = num * price;
        if(sum >= 10) sum = sum-2;
        if(sum >= 99) return sum;
        else return sum+6;

    }
}

