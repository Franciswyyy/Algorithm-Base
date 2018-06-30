package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution145 {

    private class Command{
        String s; // go, print
        TreeNode node;
        Command(String s, TreeNode node){
            this.s = s;
            this.node = node;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
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



                stack.push(new Command("print", command.node));


                if(command.node.right != null){
                    stack.push(new Command("go", command.node.right));
                }

                if(command.node.left != null){
                    stack.push(new Command("go", command.node.left));
                }
            }
        }
        return res;
    }
}
