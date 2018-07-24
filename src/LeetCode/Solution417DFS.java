package LeetCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution417DFS {

    private int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
    private int cols, columns;


    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return res;
        }


        cols = matrix.length;
        columns = matrix[0].length;
        boolean[][]pacific = new boolean[cols][columns];
        boolean[][]atlantic = new boolean[cols][columns];

        //第一行 Pacific
        for(int i = 0; i < columns; i ++){
            if(!pacific[0][i]){
                dfs(matrix, 0, i, pacific);
            }
        }


        //第一列 Pacific
        for(int i = 0; i < cols; i ++){
            if(!pacific[i][0] ){
                dfs(matrix, i, 0, pacific);
            }
        }

        //最后一行 Atlantic
        for(int i = 0; i < columns; i ++){
            if(!atlantic[cols-1][i] ){
                dfs(matrix, cols-1, i, atlantic);
            }
        }


        //最后一列 Atlantic
        for(int i = 0; i < cols; i ++){
            if(!atlantic[i][columns-1] ){
                dfs(matrix, i, columns-1, atlantic);
            }
        }

        for(int i = 0; i < cols; i ++){
            for(int j = 0; j < columns; j++){
                if(atlantic[i][j] && pacific[i][j]){
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }

    private void dfs(int[][] matrix, int x, int y, boolean[][] visited){
        visited[x][y] = true;

        for(int i = 0; i < 4; i ++){
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if(isArea(newx,newy) && !visited[newx][newy] && matrix[newx][newy] >= matrix[x][y]){
                dfs(matrix, newx, newy, visited);
            }
        }
    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < cols && y >= 0 && y < columns;
    }

    public static void main(String[] args) {
        int[][] num = {{1}};
        Solution417DFS s= new Solution417DFS();
        List<int[]> res = s.pacificAtlantic(num);
        Iterator<int[]> it = res.iterator();
        while(it.hasNext()){
            int[] cur = it.next();
            System.out.println(cur[0] + "." + cur[1]);
        }
    }
}
