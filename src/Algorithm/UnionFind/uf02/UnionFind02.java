package Algorithm.UnionFind.uf02;


//第二版 quick union   初始指向自己，集合元素指向该集合的根元素
public class UnionFind02 {

    //使用一个数组构建一颗指向父节点的树
    private int[] parent;
    private int count;   //数据个数

    public UnionFind02(int count){
        parent = new int[count];
        this.count = count;
        //初始化，使每一个parent指向自己
        for(int i = 0; i < count; i ++){
            parent[i] = i;
        }
    }

    //查找过程，查找元素p所对应的集合编号，复杂度为O(h)，h为树的高度
    private int find(int p){
        assert (p >= 0 && p < count);

        // 不断去查自己的父节点，直到达根节点
        while(p != parent[p]){
            p = parent[p];
        }
        return p;
    }


    // 查看元素p和元素q是否所属一个集合
    // O(h)复杂度, h为树的高度
    public boolean isConnected( int p , int q ){
        return find(p) == find(q);
    }


    // 合并元素p和元素q所属的集合
    // O(h)复杂度, h为树的高度
    public void union(int p, int q){

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot){
            return;
        }

        parent[pRoot] = qRoot;
    }

}
