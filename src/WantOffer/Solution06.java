package WantOffer;

import java.util.HashMap;

public class Solution06 {

    //缓存中序遍历数组中每个值对应的索引
    HashMap<Integer, Integer> indexForInOrders = new HashMap<>();
    public TreeNode1 reConstructBinaryTree(int [] pre, int [] in) {
        for(int i = 0; i < in.length; i ++)
            indexForInOrders.put(in[i], i);
        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }

    /**
     * 在数组中（左右界限），在这个数组找出根节点后，然后在中序数组中根据这个根节点来计算出该子树右多少个结点
     * 接着又跨过几个结点继续找各自的子树根节点
     *
     * @param pre   前序数组
     * @param preL
     * @param preR
     * @param inL    当前这棵子树在中序的起始位置，因为从前序得到根节点继而求出在中序的索引，再求出左右子树右多少个。
     * @return
     */
    public TreeNode1 reConstructBinaryTree(int[] pre, int preL, int preR, int inL){

        if(preL > preR) return null;
        // 如果是相等的活，则就是一个叶子节点了，还是要指向的

        TreeNode1 root = new TreeNode1(pre[preL]);
        int inIndex = indexForInOrders.get(root.val);  // 开始找前序的根在中序中的位置

        int leftTreeSize= inIndex - inL;
        root.left = reConstructBinaryTree(pre, preL+1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);
        return root;
    }
}


class TreeNode1 {

    int val;
    TreeNode1 left;
    TreeNode1 right;
    TreeNode1(int x) { val = x; }
}
