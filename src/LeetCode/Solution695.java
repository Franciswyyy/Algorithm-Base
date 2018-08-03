package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution695 {

    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};
    private boolean[][] visited;
    private int rows, columns;

    public int maxAreaOfIsland(int[][] grid) {

        rows = grid.length;
        columns = grid[0].length;

        visited = new boolean[rows][columns];

        int res = 0;

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    res = Math.max(res, bfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int x, int y){
        int num = 1;

        Queue<int[]> queue = new ArrayDeque<>();
        visited[x][y] = true;
        queue.add(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i ++){
                int newx = cur[0] + d[i][0];
                int newy = cur[1] + d[i][1];
                if(isArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == 1){
                    queue.add(new int[]{newx, newy});
                    visited[newx][newy] = true;
                    num++;
                }
            }
        }
        return num;
    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < rows && y >= 0 && y < columns;
    }

    public static void main(String[] args) {
        int[][] w = {{0,1},{1,1}};
        Solution695 s = new Solution695();
        System.out.println(s.maxAreaOfIsland(w));
    }
}
