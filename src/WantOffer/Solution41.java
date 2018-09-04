package WantOffer;

public class Solution41 {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array.length < 2) return;
        if(array.length == 2){
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }

        int bitResult = 0;
        for(int i = 0; i < array.length; i ++){
            bitResult ^= array[i];
        }

        // 找出最后AB结果中出现的1的位置，这样将结果分成两队
        int index = 0;
        while(((bitResult & 1 ) == 0) && index < 32){
            bitResult >>= 1;
            index ++;
        }

        // 找到了索引之后，开始分成两组，即把那两个重复的数给区分开了
        for(int i = 0; i < array.length; i ++){
            if(isBit(array[i], index)){
                num1[0] ^= array[i];
            }else{
                num1[1] ^= array[i];
            }
        }

    }
    private boolean isBit(int target, int index){
        return ((target >> index) & 1) == 1;
    }
}
