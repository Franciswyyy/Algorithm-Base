package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {

       List<String> res = new ArrayList<>();

       if(root == null) return res;             // 根

       if(root.left == null && root.right == null){    // 叶子节点
           res.add(String.valueOf(root.val));
           return res;
       }

       List<String> left = binaryTreePaths(root.left);
       for(int i = 0; i < left.size(); i ++){
           res.add(String.valueOf(root.val) + "->" + left.get(i));
       }

       List<String> right = binaryTreePaths(root.right);
       for(int i = 0; i < right.size(); i ++){
           res.add(String.valueOf(root.val) + "->" + right.get(i));
       }

        return res;
    }
}
