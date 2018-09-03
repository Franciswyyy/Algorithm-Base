package WantOffer;

import java.util.HashMap;

public class Solution36 {

    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array == null || array.length == 0) return 0;

        HashMap<Integer, Integer>map = new HashMap<>();
        int half = array.length/2;
        for(int i = 0; i < array.length; i ++){
            map.put(array[i], map.getOrDefault(array[i], 0)+1);
            if(map.get(array[i]) > half) return array[i];
        }
        return 0;
    }

    public static int MoreThanHalfNum(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int res = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i ++){
            if(count == 0){
                res = arr[i];
                count = 1;
            }else if (res == arr[i])
                count ++;
            else count--;
        }
        // 检测到了，如果这个数也没有超过一半的话
        count = 0;
        for(int i = 0; i < arr.length; i ++){
            if(arr[i] == res) count++;
        }
        if(count > arr.length/2) return res;
        else return 0;

    }


    public static void main(String[] args) {
//        int[] arr = new int[]{1,2,3,2,2,2,5,4,2};
        int[] arr = new int[]{1,2,3,2,4,2,5,2,3};
        System.out.println(MoreThanHalfNum_Solution(arr));
    }
}
