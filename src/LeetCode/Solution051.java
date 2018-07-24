package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution051 {


    List<List<String>> res;
    boolean[] col, dia1, dia2;

    public List<List<String>> solveNQueens(int n) {

        res = new ArrayList<>();

        col = new boolean[n];
        dia1 = new boolean[2*n-1];
        dia2 = new boolean[2*n-1];

        putQueen(n, 0, new ArrayList<Integer>());

        return res;

    }

    // n皇后问题中，摆放第index行的位置
    private void putQueen(int n, int index, List<Integer>cur){

        if(index == n){
            res.add(generateQueen(n, cur));   //结果转换一下
            return;
        }

        //将该皇后放在第index行的第i列上
        for(int i = 0; i < n; i ++){
            if(!col[i] && !dia1[index+i] && !dia2[index-i+n-1]){
                cur.add(i);
                col[i] = true;
                dia1[index+i] = true;
                dia2[index-i+n-1] = true;
                putQueen(n, index+1, cur);
                col[i] = false;
                dia1[index+i] = false;
                dia2[index-i+n-1] = false;
                cur.remove(cur.size()-1);
            }
        }
        return;
    }

    private List<String> generateQueen(int n, List<Integer>cur){

        List<String> board = new ArrayList<>();
        for(int i = 0; i < n; i ++){
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[cur.get(i)] = 'Q';
            board.add(new String(chars));
         }
         return board;
    }


    private static void printBoard(List<String> board){
        for(String s : board){
            System.out.println(s);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        int n = 8;
        List<List<String>> res = (new Solution051()).solveNQueens(n);
        for(List<String> board: res)
            printBoard(board);
    }
}
