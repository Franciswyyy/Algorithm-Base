package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int row = nums.length;
        int column = nums[0].length;

        if(row*column != (r * c)) return nums;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < row; i ++){
            for(int j = 0; j < column; j ++){
                queue.add(nums[i][j]);
            }
        }

        int[][] res = new int[r][c];
        for(int i = 0; i < r; i ++){
            for(int j = 0; j < c; j ++){
                res[i][j] = queue.poll();
            }
        }
        return res;
    }


    public int[][] matrixReshape1(int[][] nums, int r, int c){
        int row = nums.length;
        int column = nums[0].length;

        if(row*column != r*c)return nums;
        int[][] res = new int[r][c];
        for(int i = 0; i < r*c; i ++){
            res[i/c][i%c] = nums[i/column][i%column];
        }
        return res;
    }
}
