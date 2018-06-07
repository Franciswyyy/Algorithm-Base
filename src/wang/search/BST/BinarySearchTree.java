package wang.search.BST;

import java.util.Stack;

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

    //向二分搜索树中插入一个新的(key,value)数据
    public void insert(Key key, Value value){
        root = insert(root, key, value);
    }

    //查看二叉树中包含key
    public boolean contain(Key key){
        return contain(root, key);
    }

    // 在二分搜索树中搜索键key所对应的值。如果这个值不存在, 则返回null
    public Value search(Key key){
        return search(root, key);
    }

    // 二分搜索树的前序遍历
    public void preOrder(){
        preOrder(root);
    }

    public void preOrderByStack(){
        preOrderByStack(root);
    }

    // 二分搜索树的中序遍历
    public void inOrder(){
        //inOrder(root);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        //postOrder(root);
    }

    //********************
    //* 二分搜索树的辅助函数
    //********************

    //前序  递归
    private void preOrder(Node node){
        if(node == null) return;
        visit(node);
        preOrder(node.left);
        preOrder(node.right);
    }


    //前序 非递归
    private void preOrderByStack(Node p){
        if(p == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(p);
        while(!stack.isEmpty()){
            p = stack.pop();
            if(p.right != null)
                stack.push(p.right);
            if(p.left != null)
                stack.push(p.left);
        }
    }

    //以node为根节点，插入节点(key,value),返回的插入新节点的根
    private Node insert(Node node, Key key, Value value){

        if(node == null){
            count ++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) == 0){
            node.value = value;
        }else if(key.compareTo(node.key) > 0){
            node.right = insert(node.right, key, value);
        }else {
            node.left= insert(node.left, key, value);
        }

        return node;
    }


    //查看以node为根的二分搜索树中是否包含key的节点
    private boolean contain(Node node, Key key){
        if(node == null){
            return false;
        }

        if(key.compareTo(node.key) == 0){
            return true;
        }else if(key.compareTo(node.key) < 0){
            return contain(node.left, key);
        }else {
            return contain(node.right, key);
        }
    }


    //二叉树中搜索键key对应的值，如果key不存在,则返回null
    private Value search(Node node, Key key){
        //以node为根，,搜索key所对应的value
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node.value;
        }else if(key.compareTo(node.key) > 0){
            return search(node.right, key);
        }else {
            return search(node.left, key);
        }
    }


    //放问该节点的值
    private void visit(Node node){
        System.out.print(node.value + " ");
    }


    //测试成功
    public static void main(String[] args) {
        int N = 10;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = new Integer(i);

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }

        BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();
        for(int i = 0 ; i < N ; i ++)
            bst.insert(new Integer(arr[i]), Integer.toString(arr[i]));

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }
    }

}
