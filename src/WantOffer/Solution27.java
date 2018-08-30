package WantOffer;

public class Solution27 {

    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null) return null;

        // 1. 有右结点，右边的最左边
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        // 2. 左叶子结点，直接是父结点
        while(pNode.next != null){
            TreeLinkNode parent = pNode.next;
            if(parent.left == pNode)
                return parent;
            pNode = pNode.next;
        }
        return null;
    }
}
