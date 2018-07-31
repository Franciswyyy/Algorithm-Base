package LeetCode;

public class Solution063 {



    public int uniquePath(int[][] grid){
        int width = grid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for(int[] row : grid){
            for(int j = 0; j < width; j ++){
                if(row[j] == 1){
                    dp[j] = 0;
                }else if (j > 0){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[width-1];
    }



    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;      // 行
        int columns = obstacleGrid[0].length;  // 列

        int[][] dp = new int[rows][columns];

        for(int i = 0; i < rows; i ++){
            if(obstacleGrid[i][0] == 1){
                while(i < rows){
                    dp[i][0] = 0;
                    i++;
                }
                break;
            }
            dp[i][0] = 1;
        }

        for(int i = 0; i < columns; i ++){
            if(obstacleGrid[0][i] == 1){
                while(i < columns){
                    dp[0][i] = 0;
                    i++;
                }
                break;
            }
            dp[0][i] = 1;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < columns; j ++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[rows-1][columns-1];
    }


}
