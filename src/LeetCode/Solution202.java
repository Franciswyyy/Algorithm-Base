package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class Solution202 {


    public boolean isHappy1(int n){
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        while(n != 1){
            int res = fun(n);
            if(set.contains(res)){
                return false;
            }
            set.add(res);
            n = res;
        }
        return true;
    }


    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(slow > 1){
            slow = fun(slow);
            if(slow == 1) return true;
            fast = fun(fun(fast));
            if(fast == 1) return true;

            if(slow == fast) return false;
        }
        return true;
    }

    private int fun(int n){
        int sum = 0, tmp;
        while(n != 0){
            tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        return sum;
    }

}
