package LeetCode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Solution130 {

    private int directed[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean[][] visited;
    private int rows,columns;

    public void solve(char[][] board) {

        rows = board.length;
        columns = board[0].length;

        visited = new boolean[rows][columns];
        Queue<int[]>queue = new ArrayDeque<>();

       for(int i = 0; i < rows; i ++){
           for(int j = 0; j < columns; j ++){
               if((i == 0 || i == rows-1 || j == 0 || j == columns-1) && !visited[i][j] && board[i][j] == 'O'){
                   board[i][j] = 'B';
                   visited[i][j] = true;
                   queue.offer(new int[]{i, j});
               }
           }
       }

       while(!queue.isEmpty()){
           int[] cur = queue.poll();
           for(int i = 0; i < 4; i ++){
               int newx = cur[0] + directed[i][0];
               int newy = cur[1] + directed[i][1];
               if(isArea(newx, newy) && !visited[newx][newy] && board[newx][newy] == 'O'){
                   board[newx][newy] = 'B';
                   visited[newx][newy] = true;
                   queue.offer(new int[]{newx, newy});
               }
           }
       }



        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                if(board[i][j] == 'B'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public static void main(String[] args) {
        char[][] num = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        Solution130 s = new Solution130();
        for(int i = 0; i < num.length; i ++){
            for(int j = 0; j < num[0].length; j ++){
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
        s.solve(num);
        for(int i = 0; i < num.length; i ++){
            for(int j = 0; j < num[0].length; j ++){
                System.out.print(num[i][j] + "\t");
            }
            System.out.println();
        }

    }

}
