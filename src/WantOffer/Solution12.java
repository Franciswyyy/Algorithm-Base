package WantOffer;

public class Solution12 {

    /**
     * 青蛙跳台阶，只能跳1级或2级，求跳到n级的方法?
     * 青蛙跳到n阶台阶，有两种，跳1下或者跳2下
     * 错误代码，target应该从1考虑
     * @param target
     * @return
     */
    public int JumpFloor1(int target) {
        if(target <= 2) return target;

        int one = 1;
        int two = 2;
        int result = 0;
        for(int i = 3; i <= target; i ++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    // 从上到下的计算，有大量重复值
    public int JumpFloor(int target) {
        if(target <= 0) return -1;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else return JumpFloor(target-1) + JumpFloor(target-2);
    }
}
