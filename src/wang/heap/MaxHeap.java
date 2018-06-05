package wang.heap;

// 最大堆,父节点从1开始的
public class MaxHeap<Item extends Comparable>{
//Item要比较大小,所以要继承Comparable接口

    protected Item[] data;
    protected int count;
    protected int capacity;

    //构造函数，构造一个空堆，可容纳capacity个元素
    public MaxHeap(int capacity) {
        data = (Item[])new Comparable[capacity + 1];   // 0索引不用
        count = 0;
        this.capacity = capacity;
    }

    //构造函数，通过给定一个数组创建一个最大堆，构建堆的过程，时间复杂度为O(n)
    public MaxHeap(Item[] arr){
        int n = arr.length;

        data = (Item[])new Comparable[n+1];
        capacity = n;

        for(int i = 0; i < n; i ++){
            data[i+1] = arr[i];
        }
        count = n;

        for(int i = count/2; i >= 1; i --){
            shiftDown(i);
        }

    }

    //返回堆中个数
    public int size(){
        return count;
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //在最大堆中插入一个新的元素 item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }
    private void shiftUp(int k){

        while(k > 1 && data[k/2].compareTo(data[k]) < 0){
            swap(k, k/2);
            k /= 2;
        }
    }
    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }


    //从最大堆中取出堆顶元素，即堆中所存储的最大数据
    public Item extractMax(){
        assert count > 0;
        Item res = data[1];
        swap(1, count);
        count --;
        shiftDown(1);

        return res;
    }
    private void shiftDown(int k){

        while( 2*k <= count){
            int j = 2*k;
            if(j+1 <= count && data[j+1].compareTo(data[j]) > 0) j++;
            if(data[k].compareTo(data[j]) >= 0) break;
            swap(k, j);
            k = j;   // k就下来了,j是k的子节点
        }

    }

    //获取堆中最大元素
    public Item getMax(){
        assert (count > 0);
        return data[1];
    }

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 100;  //堆中个数
        int M = 100;  //值的范围
        for(int i = 0; i < N; i ++){
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }
        System.out.println(maxHeap.size());

        Integer[] arr = new Integer[N];
        //从堆中取出来,应该是从大到小取出来
        for(int i = 0; i < N; i ++){
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //确保数组从大到小排列的
        for(int i = 1; i < N; i ++){
            assert arr[i-1] >= arr[i];
        }
    }
}
