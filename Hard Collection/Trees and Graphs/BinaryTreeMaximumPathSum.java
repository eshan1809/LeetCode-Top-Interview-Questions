/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max;
    
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        return Math.max(helper(root), max);
    }
    
    private int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left), right = helper(root.right), ans = root.val;
        if(left > 0)
            ans += left;
        if(right > 0)
            ans += right;
        max = Math.max(max, ans);
        return Math.max(Math.max(left, right) + root.val, root.val);
    }
}
