package wang.search.BST;

public class BinarySearchTree <Key extends Comparable<Key>, Value>{

    //数的结点为私有类
    private class Node{
        private Key key;
        private Value value;
        private Node left, right;

        Node(Key key, Value value){
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int count;

    public BinarySearchTree() {
        root = null;
        count = 0;
    }

    //节点中的个数
    public int size(){
        return count;
    }

    //判断是否为空
    public boolean isEmpty(){
        return count == 0;
    }

    //向二分搜索树中插入一个新的(key,value)数据对，返回的是根节点
    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }

    private Node insert(Node node, Key key, Value value){

        if(node == null){
            count ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) == 0){
            node.value = value;
        }else if(key.compareTo(node.key) > 0){
            node.left = insert(node.left, key, value);
        }else {
            node.right = insert(node.right, key, value);
        }

        return node;
    }


}
