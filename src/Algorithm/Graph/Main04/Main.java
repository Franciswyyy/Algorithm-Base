package Algorithm.Graph.Main04;

import Algorithm.Graph.Path;
import Algorithm.Graph.ReadGraph;
import Algorithm.Graph.ShortestPath;
import Algorithm.Graph.SparseGraph;

// 用dfs求出两点之间的路径，不一定是最优的~
public class Main {

    public static void main(String[] args) {

        String filename = "F:\\Algorithm-Base\\src\\Algorithm\\Graph\\testG3.txt";
        SparseGraph g= new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g, 0);
        System.out.println("DFS Path from 0 to 6:");
        path.showPath(6);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.println("BFS Path from 0 to 6:");
        bfs.showPath(6);
    }
}
