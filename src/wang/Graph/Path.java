package wang.Graph;

import java.util.Stack;
import java.util.Vector;

public class Path {

    private Graph G;   //图的引用
    private int s;    //起始点  source
    private boolean[] visited;   //记录dfs是否被访问过
    private int[] from;     // 记录路径, from[i]表示查找的路径上i的上一个节点


    public Path(Graph graph, int s) {

        G = graph;
        assert s >= 0 && s < G.V();

        visited = new boolean[G.V()];
        from = new int[G.V()];

        for(int i = 0; i < G.V(); i ++){
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;

        //寻路算法
        dfs(s);
    }

    // 图的深度优先遍历
    private void dfs(int v){
        visited[v] = true;
        for(int node : G.adj(v)){
            if(!visited[node]){
                from[node] = v;    // 设置node的前一个节点为v
                dfs(node);
            }
        }
    }

    //查询s到w是否有路径
    boolean hasPath(int w){
        assert w >= 0 && w < G.V();
        return visited[w];
    }

    // 查询从s到w点的路径，存在res中
    public Vector<Integer> path(int w){

        assert hasPath(w);

        Stack<Integer> stack = new Stack<Integer>();
        //通过from数组逆向查找
        int p = w;
        while( p != -1){
            //其实的s的form是-1
            stack.push(p);
            p = from[p];
        }

        //从栈中依次取出元素，获得顺序的从s到w的路径
        Vector<Integer> res = new Vector<Integer>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }

    //打印出从s到w点的路径
    public void showPath(int w){

        assert hasPath(w);

        Vector<Integer> res = path(w);
        for(int i = 0; i < res.size(); i ++){
            System.out.print(res.get(i));
            if( i == res.size()-1){
                System.out.println();
            }else {
                System.out.print(" -> ");
            }
        }
    }
}
