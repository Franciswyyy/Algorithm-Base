package wang.search;

//非递归二分查找
public class BinarySearch {

    private BinarySearch(){}

    // arr为有序，在arr数组中找target
    public static int find(Comparable[] arr, Comparable target){
        // 在arr[l...r]之中查找target
        int l = 0, r = arr.length - 1;
        while(l <= r){

            int mid = (r - l)/2 + l;

            if(arr[mid].compareTo(target) == 0){
                return mid;
            }else if(arr[mid].compareTo(target) > 0){
                r = mid - 1;
            }else if(arr[mid].compareTo(target) < 0){
                l = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int N = 1000000;
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 对于我们的待查找数组[0...N)
        // 对[0...N)区间的数值使用二分查找，最终结果应该就是数字本身
        // 对[N...2*N)区间的数值使用二分查找，因为这些数字不在arr中，结果为-1
        for(int i = 0 ; i < 2*N ; i ++) {
            int v = BinarySearch.find(arr, new Integer(i));
            if (i < N)
                assert v == i;
            else
                assert v == -1;
        }

        return;
    }
}
