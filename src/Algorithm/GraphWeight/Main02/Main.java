package Algorithm.GraphWeight.Main02;

import Algorithm.GraphWeight.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        String filename = "F:\\Algorithm-Base\\src\\Algorithm\\GraphWeight\\testG1.txt";
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


        // Test Prim MST
        System.out.println("Test Prim MST:");
        PrimMST<Double> primMST = new PrimMST<Double>(g);
        List<Edge<Double>> mst1 = primMST.mstEdges();
        for( int i = 0 ; i < mst1.size() ; i ++ )
            System.out.println(mst1.get(i));
        System.out.println("The MST weight is: " + primMST.result());

        System.out.println();


        // Test Kruskal
        System.out.println("Test Kruskal:");
        KruskalMST<Double> kruskalMST = new KruskalMST<Double>(g);
        List<Edge<Double>> mst2 = kruskalMST.mstEdges();
        for( int i = 0 ; i < mst2.size() ; i ++ )
            System.out.println(mst2.get(i));
        System.out.println("The MST weight is: " + kruskalMST.result());

        System.out.println();
    }
}
