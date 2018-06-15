package wang.UnionFind.uf03;


//第三版 quick union     保证每次都是最小集合指向多的集合
public class UnionFind03 {


    private int[] parent;  //parent[i]表示第一个元素所指向的父节点
    private int[] size;
    private int count;   //数据个数

    public UnionFind03(int count){
        parent = new int[count];
        size = new int[count];
        this.count = count;
        //初始化，使每一个parent指向自己
        for(int i = 0; i < count; i ++){
            parent[i] = i;
            size[i] = 1;
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

        //根据两个元素所在树的元素个数不同判断合并方向
        //将元素个数少的集合合并到元素个数多的集合上
        if(size[pRoot] < size[qRoot]){
            parent[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }else {
            parent[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
    }

}
