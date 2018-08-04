package Algorithm.Graph.Main03;

import Algorithm.Graph.Components;
import Algorithm.Graph.ReadGraph;
import Algorithm.Graph.SparseGraph;

//用于测试无权图的联通分量
public class Main {

    public static void main(String[] args) {

        // TestG1.txt
        String filename = "F:\\Algorithm-Base\\src\\Algorithm\\Graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "F:\\Algorithm-Base\\src\\Algorithm\\Graph\\testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

    }
}
