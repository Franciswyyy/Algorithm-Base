package LeetCode;

import javafx.util.Pair;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution200BFS {

    private int[][] d= new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int m,n;
    private boolean[][] visited;

    public int numIslands(char[][] grid) {

        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    res ++;
                    BFS(grid, i, j);
                }
            }
        }
        return res;
    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    private void BFS(char[][] grid, int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        //queue.add(new Pair(x, y));
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for(int i = 0; i < 4; i ++){
                int newx = cur[0] + d[i][0];
                int newy = cur[1] + d[i][1];
                if(isArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1'){
                    queue.add(new int[]{newx, newy});
                    visited[newx][newy] = true;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        char[][] num = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        Solution200BFS s = new Solution200BFS();
        System.out.println(s.numIslands(num));
    }
}
