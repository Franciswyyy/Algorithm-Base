package WantOffer;

// 小青蛙变态跳
public class Solution13 {

    // 一个很基本的数学公式
    public int JumpFloorII(int target) {
        if(target <= 0) return -1;
        else if(target == 1) return 1;
        else return 2 * JumpFloorII(target-1);
    }
}
