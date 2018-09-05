package WantOffer;

public class Solution45 {
    public int NumberOf1(int n) {

        // 要考虑数是负数的情况

     int count = 0;
     while(n != 0){
         if((n & 1) == 1)
             count ++;
         n = n >>> 1;
     }
     return count;
    }

    public int NumberOf2(int n) {

        int count = 0;
        while (n != 0){
            count ++;
            n = n & (n-1);
        }
        return count;
    }
}
