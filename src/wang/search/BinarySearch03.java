package wang.search;

public class BinarySearch03 {

    private BinarySearch03(){}

    public static int find(Comparable[] arr, Comparable target) {

        // 在arr[l...r]之中查找target
        int l = 0, r = arr.length-1;
        while( l <= r ){
            int mid = l + (r-l)/2;
            if( arr[mid].compareTo(target) == 0 )
                return mid;
            if( arr[mid].compareTo(target) > 0 )
                r = mid - 1;
            else
                l = mid + 1;
        }

        return -1;
    }

    static int floor(Comparable[] arr, Comparable target){

        // 寻找比target小的最大索引
        int l = -1, r = arr.length-1;
        while( l < r ){
            // 使用向上取整避免死循环
            int mid = l + (r-l+1)/2;
            if( arr[mid].compareTo(target) >= 0 )
                r = mid - 1;
            else
                l = mid;
        }

        assert l == r;

        // 如果该索引+1就是target本身, 该索引+1即为返回值
        if( l + 1 < arr.length && arr[l+1] == target )
            return l + 1;

        // 否则, 该索引即为返回值
        return l;
    }

    static int ceil(Comparable[] arr, Comparable target){

        // 寻找比target大的最小索引值
        int l = 0, r = arr.length;
        while( l < r ){
            // 使用普通的向下取整即可避免死循环
            int mid = l + (r-l)/2;
            if( arr[mid].compareTo(target) <= 0 )
                l = mid + 1;
            else // arr[mid] > target
                r = mid;
        }

        assert l == r;

        // 如果该索引-1就是target本身, 该索引+1即为返回值
        if( r - 1 >= 0 && arr[r-1] == target )
            return r-1;

        // 否则, 该索引即为返回值
        return r;
    }

    public static void main(String[] args){

        Integer arr[] = new Integer[]{1, 1, 1, 2, 2, 2, 2, 2, 4, 4, 5, 5, 5, 6, 6, 6};
        for( int i = 0 ; i <= 8 ; i ++ ){

            int floorIndex = floor(arr, i);
            System.out.println("the floor index of " + i + " is " + floorIndex + ".");
            if( floorIndex >= 0 && floorIndex < arr.length )
                System.out.println("The value is " + arr[floorIndex] + ".");
            System.out.println();

            int ceilIndex = ceil(arr, i);
            System.out.println("the ceil index of " + i + " is " + ceilIndex + ".");
            if( ceilIndex >= 0 && ceilIndex < arr.length )
                System.out.println("The value is " + arr[ceilIndex] + ".");
            System.out.println();

            System.out.println();
        }

    }
}
