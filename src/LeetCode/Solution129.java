package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {

    public int sumNumbers(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root, new StringBuffer(), res);
        return String2int(res);
    }

    public void helper(TreeNode root, StringBuffer sb, List<String> res){
        if(root == null) return;

        sb.append(root.val);

        if(root.right == null && root.left == null){
            res.add(new String(sb));
            return;
        }
        if(root.left != null){
            helper(root.left, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
        if(root.right != null){
            helper(root.right, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public int String2int(List<String> res){
        if(res == null) return 0;

        int sum = 0;
        for(String s : res){
            int num = 0;
            char[] chars = s.toCharArray();
            for(int i = 0; i < chars.length; i ++){
                int c = chars[i] - '0';
                num = num*10 + c;
            }
            sum += num;
        }
        return sum;
    }


    public int sumNumbers1(TreeNode root){
        List<String> res = new ArrayList<>();
        res = helper2(root);
        return String2int(res);
    }

    public List<String> helper2(TreeNode root){
        List<String> res = new ArrayList<>();
        if(root == null) return res;

        if(root.right == null && root.left == null){
            res.add(String.valueOf(root.val));
            return res;
        }

        List<String> left = helper2(root.left);
        for(int i = 0; i < left.size(); i ++){
            res.add(String.valueOf(root.val) + "" + left.get(i));
        }

        List<String> right = helper2(root.right);
        for(int i = 0; i < right.size(); i ++){
            res.add(String.valueOf(root.val) +""+ right.get(i));
        }
        return res;
    }



}
