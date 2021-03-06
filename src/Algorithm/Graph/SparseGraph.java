package Algorithm.Graph;

import java.util.ArrayList;
import java.util.List;


// 稀疏图  邻接表
public class SparseGraph implements Graph{

    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;    // 是否为有向图
    private List<Integer>[] g; // 图的具体数据

    public SparseGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;   // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector,表示每个g[i]都为空，即没有任何边
        g = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
    }

    public int V(){ return n; }    // 返回节点个数
    public int E(){ return m; }    // 返回边的个数

    // 向图中添加一个边
    public void addEdge(int v, int w){

        assert v >= 0 && v < n ;
        assert w >= 0 && w < n ;

        g[v].add(w);
        if( v != w && !directed )  //判断了自环边和有向边
            g[w].add(v);

        m ++;
    }

    // 验证图中是否有从v到w的边   复杂度最差为O(n),所以在添加边中不判断是否有平行边问题，题目会有要求
    public boolean hasEdge(int v, int w){

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for(int i = 0; i < g[v].size(); i ++){
            if(g[v].get(i) == w)
                return true;
        }
        return false;

    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    // 显示图的信息
    public void show(){

        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ )
                System.out.print(g[i].get(j) + "\t");
            System.out.println();
        }
    }
}
