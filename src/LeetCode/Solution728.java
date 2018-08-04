package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = left; i <= right; i ++){
            int j = i;
            for(; j > 0; j /= 10){
                // 如果能被10除的话，那么就会有0, 则不算自除数
                if((j % 10 == 0) || (i % (j%10) != 0)) break;
            }
            if(j == 0) list.add(j);
        }
        return list;
    }



    public List<Integer> selfDividingNumbers1(int left, int right) {

        List<Integer> res = new ArrayList<>();
        for(int i = left; i <= right; i ++){
            int cur = i;
            while(cur != 0){
                int single = cur % 10;
                if(i % single != 0) break;
                cur /= 10;
            }
            if(cur == 0) res.add(i);
        }
        return res;
    }



}
