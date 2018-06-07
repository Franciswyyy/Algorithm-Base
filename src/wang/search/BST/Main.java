package wang.search.BST;

public class Main {

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8,6,3,9,7,0,1,4,5,2};

        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();

        for(int i = 0; i < arr.length; i ++){
            Integer key = arr[i];
            bst.insert(key, key);   //方便让key,value一样
            System.out.print(key + " ");
        }

    }
}
