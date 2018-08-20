package WantOffer;

public class Solution03 {
    public static boolean Find(int target, int [][] array) {
        if(array == null || array.length == 0
                || array[0].length == 0) return false;

        int rows = array.length;
        int cols = array[0].length;

        for(int i = 0; i < rows; i ++){
            if(array[i][cols-1] < target){
                continue;
            }else if(array[i][cols-1] == target){
                return true;
            }else if(array[i][cols-1] > target){
                for(int j = 0; j < cols; j ++){
                    if(array[i][j] == target)
                        return true;
                }
            }
        }
        return false;
    }

    //论代码书写的重要性
    public static boolean Find1(int target, int [][] array) {
        if(array == null || array.length == 0
                || array[0].length == 0) return false;

        int rows = array.length;
        int cols = array[0].length;
        int r = 0, c = cols-1; //从左上角开始
        while(r <= rows-1 && c >= 0){
            if(target == array[r][c])
                return true;
            else if(target > array[r][c])
                r ++;
            else
                c --;
        }
        return false;
    }
}
