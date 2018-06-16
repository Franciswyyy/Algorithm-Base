package wang.GraphWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


// Kruskal算法求最小生成树
public class KruskalMST<Weight extends Number & Comparable> {

    private List<Edge<Weight>> mst;   // 最小生成树所包含的所有边
    private Number mstWeight;           // 最小生成树的权值

    // 构造函数, 使用Kruskal算法计算graph的最小生成树
    public KruskalMST(WeightedGraph graph){

        mst = new ArrayList<Edge<Weight>>();

        // 将图中的所有边存放到一个最小堆中
        MinHeap<Edge<Weight>> pq = new MinHeap<Edge<Weight>>( graph.E() );
        for( int i = 0 ; i < graph.V() ; i ++ )
            for( Object item : graph.adj(i) ){
                Edge<Weight> e = (Edge<Weight>)item;

                // 由于是无向图，为了是要加入一条边，   12  21表示的是一条边
                if( e.v() <= e.w() )
                    pq.insert(e);
            }

        // 创建一个并查集, 来查看已经访问的节点的联通情况
        UnionFind uf = new UnionFind(graph.V());
        while( !pq.isEmpty() && mst.size() < graph.V() - 1 ){

            // 从最小堆中依次从小到大取出所有的边
            Edge<Weight> e = pq.extractMin();
            // 如果该边的两个端点是联通的, 说明加入这条边将产生环, 扔掉这条边
            if( uf.isConnected( e.v() , e.w() ) )
                continue;

            // 否则, 将这条边添加进最小生成树, 同时标记边的两个端点联通
            mst.add( e );
            uf.unionElements( e.v() , e.w() );
        }

        // 计算最小生成树的权值
        mstWeight = mst.get(0).wt();
        for( int i = 1 ; i < mst.size() ; i ++ )
            mstWeight = mstWeight.doubleValue() + mst.get(i).wt().doubleValue();
    }

    // 返回最小生成树的所有边
    public List<Edge<Weight>> mstEdges(){
        return mst;
    }

    // 返回最小生成树的权值
    public Number result(){
        return mstWeight;
    }



}