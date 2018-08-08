package WorkPrepare.Pinduoduo2018;

import java.util.Arrays;
import java.util.Scanner;

public class Solution03{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int cols = in.nextInt();
        int m = in.nextInt();
        int[][] data = new int[cols][cols];
        for(int i = 0; i < cols; i++)
            for(int j = 0; j < cols; j++)
                data[i][j] = 0;
        in.nextLine();
        for(int i = 0; i < cols; i++){
            String tmp = in.nextLine();
            String[] cur = tmp.split(" ");
            for(int j = 0; j < cur.length; j++){
                int des = Integer.valueOf(cur[j]);
                data[i][des] = 1;
                data[des][i] = 1;
            }
        }
        System.out.println(helper(data,m,cols));

    }
    public static int helper(int[][] matrix, int m,int n){
        int[] tmp = new int[n];
        for(int i = 0; i < n; i++)
            tmp[i] = 0;
        for(int i = 0; i < n; i++){
            if(matrix[m][i] == 1){
                for(int j = 0; j < n; j++){
                    if(j == m)
                        continue;
                    if(matrix[m][j] == 1)
                        continue;
                    if(matrix[j][i] == 1)
                        tmp[j] ++;
                }
            }
        }
        int max = 0;
        for(int i = 1; i< n; i++){
            if(tmp[max] < tmp[i])
                max = i;
        }
        if(tmp[max] == 0)
            return -1;
        else
            return max;
    }
}