package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atest {

    public static void main(String[] args) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tmp = Arrays.asList(1,2,3);
        List<Integer> tmp1 = Arrays.asList(2,3,4);
        res.add(tmp1);


        res.add(new ArrayList<>(tmp));
        /*
        for(List<Integer> i : res){
            System.out.println(i);
        }*/

        System.out.println(res);
        tmp1.set(1,54);
        tmp.set(1,44);
        System.out.println(res);
    }
}
