package Algorithm.UnionFind.uf01;

//第一版，本质上是数组，每个索引上有值，相等即为一组
public class UnionFind01 {

    private int[] id;
    private int count;  //数据个数


    public UnionFind01(int n) {
        count = n;
        id = new int[n];
        //初始化，每一个id[i]指向自己，没有合并元素，都是自己一个组
        for(int i = 0; i < n; i ++){
            id[i] = i;
        }
    }

    // 查找过程, 查找元素p所对应的集合编号
    // O(1)复杂度
    private int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    // 查看元素p和元素q是否所属一个集合
    // O(1)复杂度
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    //合并两个元素，说明这两个组所有的元素都要合并到一个组
    public void union(int p, int q){

        int pID = find(p);
        int qID = find(q);

        if(qID == pID){
            return;
        }

        for(int i = 0; i < count; i ++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
    }
}

