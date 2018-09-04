package WantOffer;

import java.util.Arrays;

public class Solution39 {
    public int count = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0) return 0;


        sort(array, 0, array.length-1);
        return count%1000000007;
    }

    private void sort(int[] array, int l, int r){
        if(l >= r) return;

        int mid = (l + r) >> 1;
        sort(array, l, mid);
        sort(array, mid+1, r);
        merge(array, l, mid, r);
    }
    private void merge(int[] array, int l, int mid, int r){
        int[] tmp = new int[r-l+1];

        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r){
            if(array[i] <= array[j]){
                tmp[k++] = array[i++];
            }else {
                tmp[k++] = array[j++];
                count += mid - i + 1;
                if(count >= 1000000007){
                    count = count%1000000007;
                }
            }
        }

        while(i <= mid) tmp[k++] = array[i++];
        while(j <= r) tmp[k++] = array[j++];
        for(k = 0; k < tmp.length; k ++)
            array[l+k] = tmp[k];

    }


}
