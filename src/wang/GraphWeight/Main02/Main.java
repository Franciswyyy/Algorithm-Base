package wang.GraphWeight.Main02;

import wang.GraphWeight.Edge;
import wang.GraphWeight.LazyPrimMST;
import wang.GraphWeight.ReadWeightedGraph;
import wang.GraphWeight.SparseWeightedGraph;

import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        String filename = "F:\\Algorithm-Base\\src\\wang\\GraphWeight\\testG1.txt";
        int V = 8;

        SparseWeightedGraph<Double> g = new SparseWeightedGraph<Double>(V, false);
        ReadWeightedGraph readGraph = new ReadWeightedGraph(g, filename);

        // Test Lazy Prim MST
        System.out.println("Test Lazy Prim MST:");
        LazyPrimMST<Double> lazyPrimMST = new LazyPrimMST<Double>(g);
        List<Edge<Double>> mst = lazyPrimMST.mstEdges();
        for( int i = 0 ; i < mst.size() ; i ++ )
            System.out.println(mst.get(i));
        System.out.println("The MST weight is: " + lazyPrimMST.result());

        System.out.println();
    }
}
