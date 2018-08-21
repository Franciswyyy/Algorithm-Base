package WantOffer;

public class Solution07 {

    public TreeLinkNode GetNext(TreeLinkNode pNode){

        if(pNode.right != null){
            TreeLinkNode node =  pNode.right;
            while(node.left != null)
                node = node.left;
            return node;
        }else{
            while(pNode.next != null){
                TreeLinkNode parent = pNode.next;   // 该节点的父节点
                if(parent.left == pNode) return parent;
                pNode = pNode.next;  //如果不是父节点的左子树，则依旧往上走
            }
        }
        return null;
    }
}


// 该二叉树节点不仅包含左右子节点，同时包含指向父结点的指针
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}