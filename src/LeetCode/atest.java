package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class atest {

    public static void main(String[] args) {
        int[][] a = {{10,2,10,4},{5,10,7,8},{9,10,11,12},{10,14,15,10}};
        int rows = a.length;
        int columns = a[0].length;
        System.out.println("row:" + rows + ", columns:" + columns);

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("------------------");


        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                if((i== 0 || i == rows-1 || j ==0 || j == columns-1) && a[i][j] == 10){
                    a[i][j] = 99;
                }
            }
        }

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
    }

}
