package WantOffer;

public class Solution14 {

    // 从上到下，有大量的重复值
    public int RectCover(int target) {
        if(target <= 0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else return RectCover(target-1) + RectCover(target-2);
    }

    // 从下到上的计算，俗称记忆化搜索
    public int RectCover1(int target) {
        if(target <= 0) return 0;
        if(target <= 2) return target;
        int one = 1;
        int two = 2;
        int res = 0;
        for(int i = 3; i <= target; i ++){
            res = one + two;
            one = two;
            two = res;
        }
        return res;
    }
}
