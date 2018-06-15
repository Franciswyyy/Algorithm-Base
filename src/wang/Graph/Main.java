package wang.Graph;

import java.util.Iterator;

// 测试通过文件读取图的信息
public class Main {

    public static void main(String[] args) {

        // 使用两种图的存储方式读取testG1.txt文件
        String filename = "F:\\Algorithm-Base\\src\\wang\\Graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        /*
        应用遍历每个节点的相邻节点
        for(int i = 0; i < g1.V(); i ++){
            Iterator<Integer> iter = g1.adj(i).iterator();
            System.out.print("第" + i + "个顶点所相邻的结点：");
            while(iter.hasNext()){
                System.out.print(iter.next() + " ");
            }
            System.out.println();
        }*/



        System.out.println("test G1 in Sparse Graph:");
        g1.show();

        System.out.println();

        DenseGraph g2 = new DenseGraph(13, false);
        ReadGraph readGraph2 = new ReadGraph(g2 , filename );
        System.out.println("test G1 in Dense Graph:");
        g2.show();

        System.out.println();

        // 使用两种图的存储方式读取testG2.txt文件
        filename = "F:\\Algorithm-Base\\src\\wang\\Graph\\testG2.txt";
        SparseGraph g3 = new SparseGraph(6, false);
        ReadGraph readGraph3 = new ReadGraph(g3, filename);
        System.out.println("test G2 in Sparse Graph:");
        g3.show();

        System.out.println();

        DenseGraph g4 = new DenseGraph(6, false);
        ReadGraph readGraph4 = new ReadGraph(g4, filename);
        System.out.println("test G2 in Dense Graph:");
        g4.show();


    }
}
