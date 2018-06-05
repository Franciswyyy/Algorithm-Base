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

    //返回堆中个数
    public int size(){
        return count;
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }


    private void shiftUp(int k){

        while(k > 1 && data[k/2].compareTo(data[k]) < 0){
            swap(k, k/2);
            k /= 2;
        }
    }

    //在最大堆中插入一个新的元素 item
    public void insert(Item item){

        assert count + 1 <= capacity;
        data[count + 1] = item;
        count ++;
        shiftUp(count);
    }

    private void swap(int i, int j){
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    //test
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        int N = 10;  //堆中个数
        int M = 100;  //值的范围
        for(int i = 0; i < N; i ++){
            maxHeap.insert(new Integer((int)(Math.random() * M)));
        }
        System.out.println(maxHeap.size());
    }
}
