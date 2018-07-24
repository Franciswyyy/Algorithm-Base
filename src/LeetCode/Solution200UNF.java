package LeetCode;

public class Solution200UNF {

    private int[][] d= new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    private int m,n;
    private boolean[][] visited;

    private boolean isArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        visited = new boolean[m][n];
        UNF uf = new UNF(grid);

        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    visited[i][j] = true;
                    for(int[] cur : d){
                        int newx = i + cur[0];
                        int newy = j + cur[1];
                        if(isArea(newx,newy) && grid[newx][newy] == '1' && !visited[newx][newy]){
                            int id1 = i * n + j;
                            int id2 = newx * n + newy;
                            uf.union(id1, id2);
                        }
                    }
                }
            }
        }
        return uf.count;
    }

}

class UNF{
    int[] father;
    int m, n;
    int count = 0;
    UNF(char[][] grid){
        m = grid.length;
        n = grid[0].length;
        father = new int[m * n];
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j ++){
                if(grid[i][j] == '1'){
                    int id = i * n * j;
                    father[id] = id;
                    count ++;
                }
            }
        }
    }
    public void union(int node1, int node2){
        int find1 = find(node1);
        int find2 = find(node2);
        if(find1 != find2){
            father[find1] = find2;
            count--;
        }
    }

    public int find(int node){
        if(father[node] == node){
            return node;
        }

        father[node] = find(father[node]);
        return father[node];
    }
}
