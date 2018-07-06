package LeetCode;



import javafx.util.Pair;

import java.util.LinkedList;

public class Solution279 {

    // Pair类，配对，类似属于Key,Value的整数对。
    public int numSquares(int n) {

        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0) return step;

            for(int i = 1; num - i*i >= 0; i ++){
                int a = num - i*i;
                if(!visited[a]){
                    if(a == 0) return step + 1;
                    queue.addLast(new Pair<Integer, Integer>(a, step + 1));
                    visited[a] = true;
                }
            }
        }
        throw  new IllegalStateException("No Solution");
    }
}
