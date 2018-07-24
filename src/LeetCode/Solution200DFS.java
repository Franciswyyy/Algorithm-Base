package LeetCode;

public class Solution200DFS {

    private int d[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    private int m, n;
    private boolean[][] visited;

    // 数组中1表示陆地，0表示水域
    public int numIslands(char[][] grid) {

        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;

        visited = new boolean[m][n];

        int res = 0;
        for(int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                //当这一块为陆地，且没有访问过，则是一块新的岛屿，深度遍历一遍
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res++;

                    // 进行flood fill， 对于同属于全部标记，实质上就是dfs
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }


    /*
    疑问：
    为什么这个递归没有写终止条件呢？
       因为每次访问这个xy这个点都是合法的，且都是没有访问的。
       条件是在if语句里，要不是陆地，水，已经访问的。
    进入dfs并没有回溯，没有将visited[x][y]置于false
        目的是要相邻的点都标记上，而不是为了找一条路径。
        一般的，搜索时要回去的，递归也是要回去的，没有对一些信息重置，
     */

    private void dfs(char[][] grid, int x, int y){

        visited[x][y] = true;

        // 从xy这个这个点的上右下左出发
        for(int i = 0; i < 4; i ++){
            int newx = x + d[i][0];
            int newy = y + d[i][1];
            if(isArea(newx, newy) && !visited[newx][newy] && grid[newx][newy] == '1'){
                dfs(grid, newx, newy);
            }
        }
        return;
    }
}
