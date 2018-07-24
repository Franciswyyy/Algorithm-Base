package LeetCode;

public class Solution079 {


    private int[][] d = {{-1,0},{0,1},{1,0},{0,-1}};   //上右下左四个方向，为了简写，而不是全部写出来
    private boolean[][] visited;
    private int m, n;

    public boolean exist(char[][] board, String word) {

        visited = new boolean[board.length][board[0].length];
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[0].length; j ++){
                if(helper(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }


    private boolean isArea(int x, int y){
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    // 从board[x][y]开始，寻找word[index...word.size]的长度
    private boolean helper(char[][] board, String word, int index, int startx, int starty){



        if( index == word.length()-1){
            return board[startx][starty] == word.charAt(index);
        }

        if(board[startx][starty] ==word.charAt(index)){
            visited[startx][starty] = true;
            //从x,y开始，向4个方向寻找
            // 还要注意，上左下右是否是有效的
            for(int i = 0; i < 4; i ++){
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                // 新的点，要满足在内，且没有被访问过
                if(isArea(newx, newy) && !visited[newx][newy]){
                    if(helper(board, word, index+1, newx, newy))
                        return true;
                }
            }
            visited[startx][starty] = false;
        }

        return false;
    }
}
