package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution144 {

    private class Command{
        String s; // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null)
            return res;

        Stack<Command> stack = new Stack<Command>();
        stack.push(new Command("go", root));
        while(!stack.empty()){
            Command command = stack.pop();

            if(command.s.equals("print")){
                res.add(command.node.val);
            }else{
                if(command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }
                if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
                stack.push(new Command("print", command.node));
            }
        }
        return res;
    }

    // 经典方法
    public List<Integer> preorderTraversal01(TreeNode root) {
        if(root == null) return null;

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            res.add(tmp.val);
            if(tmp.right != null){
                stack.push(tmp.right);
            }
            if(tmp.left != null){
                stack.push(tmp.left);
            }
        }
        return res;
    }

}
