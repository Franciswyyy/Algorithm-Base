package wang.Graph;

// 求无权图的联通分量
public class Components {

    Graph G;    // 图的引用
    private boolean[] visited;   //记录是否被访问
    private int count;      //记录联通分量的个数
    private int[] id;      //每个节点所对应联通分量标记



    // 构造函数求出 无权图的联通分量
    public Components(Graph graph){

        //算法初始化
        G = graph;
        visited = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;

        for(int i = 0; i < G.V(); i ++){
            visited[i] = false;
            id[i] = -1;
        }

        //求图的联通分量
        for(int i = 0; i < G.V(); i ++){
            if(!visited[i]){
                dfs(i);
                count++;
            }
        }
    }

    // 图的深度优先遍历
    private void dfs(int v){

        visited[v] = true;
        id[v] = count;

        // G.adj表示与v相邻的节点
        for(int i : G.adj(v)){
            if(!visited[i])
                dfs(i);
        }
    }

    //返回联通分量个数
    int count(){
        return count;
    }


}
