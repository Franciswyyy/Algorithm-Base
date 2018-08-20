package WantOffer;

import java.util.HashSet;

/**
 * 只需要找出重复的，将这个重复的赋给duplication
 */
public class Solution01 {

    /**
     * 利用Set集合,时间复杂度O(1),空间复杂度O(n)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {

        HashSet<Integer> set = new HashSet<>();
        int index = 0;
        for(int i = 0; i < length; i ++){
            if(set.contains(numbers[i])){
                duplication[index] = numbers[i];
                return true;
            }else {
                set.add(numbers[i]);
            }
        }
        return false;
    }


    /**
     * 原地寻找
     * (从时间复杂度平均来看，并不是每个都要执行while的，一致直接就跳过去)
     * 时间复杂度O(1),空间复杂度O(1)
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate01(int numbers[], int length, int[] duplication){

        if(numbers == null || length < 0) return false;

        for(int i = 0; i < length; i ++){
            if(numbers[i] < 0 || numbers[i] > length-1)
                return false;
        }
        // 上述只是些判断条件，无关紧要

        for(int i = 0; i < length; i ++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]){
                    duplication[0] = numbers[i];
                    return true;
                }

                //swap
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }


}
