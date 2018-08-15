package WorkPrepare.NetEase2018Intern;

import java.util.Scanner;

public class Solution02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            long n = sc.nextLong();
            long k = sc.nextLong();

            System.out.println(helper(n,k));
        }
    }

    private static long helper(long n, long k){

        long res = 0;

        if(k==0)return n*n;

        for(long y = k+1; y <= n; y++){
            res += n/y *(y-k);

            if(n%y >= k)
                res += n%y-k+1;
        }
        return res;
    }
}
