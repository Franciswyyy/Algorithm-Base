package LeetCode.Array;

public class BinarySearch {

    public static void main(String[] args) {

        int n = (int)Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for(int i = 0 ; i < n ; i ++)
            if(i != binarySearchRecursion(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();

        System.out.println("Binary Search test complete.");
        System.out.println("Time cost: " + (endTime - startTime) + " ms");
    }

    // 前闭后闭  非递归
    private static int binarySearch(Integer[] arr, int n, int target){
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                l = mid + 1;
            }else{
                r = mid -1;
            }
        }
        return -1;
    }


    // 前闭后闭  递归
    private static int binarySearchRecursion(Integer[] arr, int n, int target){
        return binaryRecur(arr, 0, n-1, target);
    }
    private static int binaryRecur(Integer[] arr, int l, int r, int target){
        if(l > r) return -1;
        int mid = l + (r - l)/2;
        if(arr[mid] > target){
            return binaryRecur(arr, l, mid-1, target);
        }else if(arr[mid] < target){
            return binaryRecur(arr, mid+1, r, target);
        }else{
            return mid;
        }
    }

    //前闭后开
    private static int binarySearchOpenRight(Integer[] arr, int n, int target){
        int l = 0;
        int r = n;
        while(l < r){
            int mid = l + (r - l)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return -1;
    }

}
