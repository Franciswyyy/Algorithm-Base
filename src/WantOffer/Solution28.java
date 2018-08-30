package WantOffer;

public class Solution28 {

    // 递归版
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length-1);
    }

    private boolean helper(int[] a, int l, int r){
        if(l >= r) return true;
        int i = r;
        while(i > l && a[i-1] > a[r]) --i;
        for(int j = i-1; j >= l; j--){
            if(a[j] > a[r])return false;
        }
        return helper(a, l, i-1) && helper(a, i, r-1);
    }
}
