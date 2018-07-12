package LeetCode;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;

        TreeNode root = helper(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode helper(int[] nums, int left, int right){
        if(left > right) return null;

        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid-1);
        node.right = helper(nums, mid+1, right);
        return node;
    }
}
