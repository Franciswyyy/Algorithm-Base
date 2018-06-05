package wang.heap;

// 父节点从1开始的，0号索引不用的~
public class MaxHeap<Item> {

    private Item[] date;
    private int count;

    //构造函数，构造一个空堆，可容纳capacity个元素
    public MaxHeap(int capacity) {
        date = (Item[])new Object[capacity + 1];   // 0索引不用
        count = 0;
    }

    //返回堆中个数
    public int size(){
        return count;
    }

    //返回一个布尔值，表示堆中是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //test
    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
        System.out.println(maxHeap.size());
    }
}
