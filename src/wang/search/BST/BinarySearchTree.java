package wang.search.BST;

import java.util.LinkedList;
import java.util.Queue;
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

    //构造函数，默认是一颗空的二分搜索树
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
    public Node search(Key key){
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
        inOrder(root);
    }

    public void inOrderByStack(){
        inOrderByStack(root);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    public void postOrderByStack(){
        postOrderByStack(root);
    }

    //层次遍历
    public void levelOrder(){
        levelOrder(root);
    }


    //计算二叉树的深度
    public int getDepth(){
        return getDepth(root);
    }


    //寻找二分搜索树的最小键值
    public Key minimun(){
        assert count != 0;
        Node minNode =  minimun(root);
        return minNode.key;
    }


    //寻找二分搜索树的最大键值
    public Key maximum(){
        assert count != 0;
        Node maxNode = maximum(root);
        return maxNode.key;
    }


    //从二叉树中删除最小值所在节点
    public void removeMin(){
        if(root != null){
            root = removeMin(root);
        }
    }


    //从二叉树中删除最大值所在节点
    public void removeMax(){
        if(root != null){
            root = removeMax(root);
        }
    }


    //从二叉树中删除键值为key的节点
    public void remove(Key key){
        root = remove(root, key);
    }


    // 查找key的前驱
    // 如果不存在key的前驱(key不存在, 或者key是整棵二叉树中的最小值), 则返回NULL
    public Key predecessor(Key key){

        Node node = search(root, key);
        //不存在
        if(node == null) return null;

        //左子树不存在
        if(node.left == null)
            return maximum(node.left).key;

        //否则,key前驱在根节点到key的路径上
        Node preNode = predecessorFromAncestor(root, key);
        return preNode == null ? null : preNode.key;

    }


    // 查找key的后继, 递归算法
    // 如果不存在key的后继(key不存在, 或者key是整棵二叉树中的最大值), 则返回NULL
    public Key successor(Key key){

        Node node = search(root, key);
        // 如果key所在的节点不存在, 则key没有前驱, 返回NULL
        if(node == null)
            return null;

        // 如果key所在的节点右子树不为空,则其右子树的最小值为key的后继
        if(node.right != null)
            return minimun(node.right).key;

        // 否则, key的后继在从根节点到key的路径上, 在这个路径上寻找到比key大的最小值, 即为key的后继
        Node sucNode = successorFromAncestor(root, key);
        return sucNode == null ? null : sucNode.key;
    }



    // 寻找key的floor值, 递归算法
    // 如果不存在key的floor值(key比BST中的最小值还小), 返回NULL
    public Key floor(Key key){

        if( count == 0 || key.compareTo(minimun()) < 0 )
            return null;

        Node floorNode = floor(root, key);
        return floorNode.key;
    }

    // 寻找key的ceil值, 递归算法
    // 如果不存在key的ceil值(key比BST中的最大值还大), 返回NULL
    public Key ceil(Key key){

        if( count == 0 || key.compareTo(maximum()) > 0 )
            return null;

        Node ceilNode = ceil(root, key);
        return ceilNode.key;
    }




    //********************
    //* 二分搜索树的辅助函数
    //********************


    // 在以node为根的二叉搜索树中, 寻找key的floor值所处的节点, 递归算法
    private Node floor(Node node, Key key){

        if(node == null) return null;

        //如果该node的key和key相等，就是本身
        if(node.key.compareTo(key) == 0){
            return node;
        }

        //如果该node比key要大的话
        if(node.key.compareTo(key) > 0){
            return floor(node.left, key);
        }

        //如果node比key小，可能是，也能是不是
        Node tempNode = floor(node.right, key);
        if(tempNode != null)  return tempNode;
        return node;   //想当于 tempNode == null
    }



    // 在以node为根的二叉搜索树中, 寻找key的ceil值所处的节点, 递归算法
    private Node ceil(Node node, Key key){

        if( node == null )
            return null;

        // 如果node的key值和要寻找的key值相等
        // 则node本身就是key的ceil节点
        if( node.key.compareTo(key) == 0 )
            return node;

        // 如果node的key值比要寻找的key值小
        // 则要寻找的key的ceil节点一定在node的右子树中
        if( node.key.compareTo(key) < 0 )
            return ceil( node.right , key );

        // 如果node->key > key
        // 则node有可能是key的ceil节点, 也有可能不是(存在比node->key小但是大于key的其余节点)
        // 需要尝试向node的左子树寻找一下
        Node tempNode = ceil( node.left , key );
        if( tempNode != null )
            return tempNode;

        return node;
    }



    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key小的最大值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    Node predecessorFromAncestor(Node node, Key key){

        if(node.key.compareTo(key) == 0)
            return null;

        if(key.compareTo(node.key) < 0)
            // 如果当前节点大于key, 则当前节点不可能是比key小的最大值
            // 向下搜索到的结果直接返回
            return predecessorFromAncestor(node.left, key);
        else{
            assert key.compareTo(node.key) > 0;
            // 如果当前节点小于key, 则当前节点有可能是比key小的最大值
            // 向右继续搜索, 将结果存储到tempNode中
            Node tempNode = predecessorFromAncestor(node.right, key);
            if(tempNode != null)
                return tempNode;
            else
                // 如果tempNode为空, 则当前节点即为结果
                return node;
        }
    }


    // 在以node为根的二叉搜索树中, 寻找key的祖先中,比key大的最小值所在节点, 递归算法
    // 算法调用前已保证key存在在以node为根的二叉树中
    Node successorFromAncestor(Node node, Key key){

        if(node.key.compareTo(key) == 0)
            return null;

        if(key.compareTo(node.key) > 0)
            // 如果当前节点小于key, 则当前节点不可能是比key大的最小值
            // 向下搜索到的结果直接返回
            return successorFromAncestor(node.right, key);
        else{
            assert(key.compareTo(node.key) < 0);
            // 如果当前节点大于key, 则当前节点有可能是比key大的最小值
            // 向左继续搜索, 将结果存储到tempNode中
            Node tempNode = successorFromAncestor(node.left, key);
            if(tempNode != null)
                return tempNode;
            else
                // 如果tempNode为空, 则当前节点即为结果
                return node;
        }
    }



    //删除key的节点，返回删除节点后的二分搜索树的根
    private Node remove(Node node, Key key){

        if(node == null) return null;

        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else{  //找到了这个点  key == node.key

            //待删除节点左子树为空
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                count --;
                return rightNode;
            }

            //待删除的节点右子树为空
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                count --;
                return leftNode;
            }

            //待删除的左右子树都不为空， 这里找待删除节点右子树的最小节点
            Node successor = minimun(node.right);
            count ++;

            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            count --;

            return successor;
        }
    }



    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;    //不管有没有值
            node.right = null;      //要删除的不指向了
            count --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }


    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            count --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }


    //寻找最小节点
    private Node minimun(Node node){
        if(node.left == null) return node;

        return minimun(node.left);
    }


    //寻找最大节点
    private Node maximum(Node node){
        if(node.right == null) return node;

        return maximum(node.right);
    }

    //深度
    private int getDepth(Node node){
       if(node == null) return 0;
       int left = getDepth(node.left);
       int right  = getDepth(node.right);
       return left > right ? left + 1 : right + 1;
    }


    //层次遍历
    private void levelOrder(Node p){
        if(p == null) return;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(p);
        while(!q.isEmpty()){
            Node node = q.poll();
            visit(node);
            if(node.left != null) q.offer(node.left);
            if(node.right != null) q.offer(node.right);
        }
    }


    //后序  递归
    private void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        visit(node);
    }


    //后序  非递归
    /**
     * 难点在于 需要判断上次访问的结点是左子树还是右子树
       若是左子树，则跳过根节点，先进入右子树，再来访问根节点
       若是右子树，则直接访问根节点
     * @param p
     */
    private void postOrderByStack(Node p){
        if(p == null) return;
        Stack<Node> stack = new Stack<Node>();

        Node q = null;

        while(p != null){
            stack.push(p);
            p = p.left;
        }

        while(!stack.isEmpty()){
            p = stack.pop();

            if(p.right != null && p.right != q){
                stack.push(p);
                p = p.right;
                while(p != null){
                    stack.push(p);
                    p = p.left;
                }
            }else {
                visit(p);
                q = p;
            }
        }
    }

    //中序  递归
    private void inOrder(Node node){
        if(node == null) return;
        inOrder(node.left);
        visit(node);
        inOrder(node.right);
    }


    //中序  非递归
    private void inOrderByStack(Node p){
        if(p == null) return;
        Stack<Node> stack = new Stack<Node>();
        while(!stack.isEmpty() || p != null){

            while(p != null){
                stack.push(p);
                p = p.left;
            }

            if(!stack.isEmpty()){
                p = stack.pop();
                visit(p);
                p = p.right;
            }
        }
    }


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
            visit(p);
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
    private Node search(Node node, Key key){
        //以node为根，,搜索key所对应的value
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node;
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
       /* for(int i = 0 ; i < 2*N ; i ++){
            String res = bst.search(new Integer(i));
            if( i < N )
                assert res.equals(Integer.toString(i));
            else
                assert res == null;
        }*/
    }

}
