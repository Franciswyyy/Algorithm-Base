package wang.Graph.Main02;

import wang.Graph.DenseGraph;
import wang.Graph.ReadGraph;
import wang.Graph.SparseGraph;

import java.util.Iterator;

// 测试通过一个公共方法adj来读取每个节点有多少个相邻节点
public class Main {

    public static void main(String[] args) {

        String filename = "F:\\Algorithm-Base\\src\\wang\\Graph\\testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);

        //应用遍历每个节点的相邻节点
        for(int i = 0; i < g1.V(); i ++){
            Iterator<Integer> iter = g1.adj(i).iterator();
            System.out.print("第" + i + "个顶点所相邻的结点：");
            while(iter.hasNext()){
                System.out.print(iter.next() + " ");
            }
            System.out.println();
        }
    }
}
