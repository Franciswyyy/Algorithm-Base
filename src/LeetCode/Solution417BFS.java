package LeetCode;

import java.util.*;

public class Solution417BFS {


    int[][] directed = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    int m,n;
    public List<int[]> pacificAtlantic(int[][] matrix) {

        List<int[]> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length ==0){
            return res;
        }
        m = matrix.length;
        n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        Queue<int[]> pQueue = new ArrayDeque<>();
        Queue<int[]> aQueue = new ArrayDeque<>();

        // 每一行的第一个和最后一个，第一个到太平洋，最后一个到大西洋
        for(int i = 0; i < m; i++){
            pQueue.offer(new int[]{i,0});
            aQueue.offer(new int[]{i, n-1});
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }

        //每一个列
        for(int i = 0; i < n; i++){
            pQueue.offer(new int[]{0, i});
            aQueue.offer(new int[]{m-1, i});
            pacific[0][i] = true;
            atlantic[m-1][i] = true;
        }

        bfs(matrix, pQueue, pacific);
        bfs(matrix, aQueue, atlantic);

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(new int[]{i,j});
                }
            }
        }
        return res;
    }

    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited){
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i ++){
                int newx = cur[0] + directed[i][0];
                int newy = cur[1] + directed[i][1];
                if(isArea(newx, newy) && !visited[newx][newy] && matrix[newx][newy] >= matrix[cur[0]][cur[1]]){
                    visited[newx][newy] = true;
                    queue.offer(new int[]{newx, newy});
                }
            }
        }
    }

    private boolean isArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static void main(String[] args) {
        int[][] num = {{1}};
        Solution417BFS s= new Solution417BFS();
        List<int[]> res = s.pacificAtlantic(num);
        Iterator<int[]> it = res.iterator();
        while(it.hasNext()){
            int[] cur = it.next();
            System.out.println(cur[0] + "." + cur[1]);
        }
    }

}
