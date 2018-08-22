package WantOffer;

public class Solution18 {

    // 插排思想，是奇数就往前移动
    public void reOrderArray(int [] array) {

        int index = 0;
        int i = 0;
        for(; i < array.length; i ++){
            if(array[i] % 2 == 1){
                int temp = array[i];
                for(; i>index;i--){
                    array[i] = array[i-1];
                }
                array[index++] = temp;
            }
        }
    }


}
