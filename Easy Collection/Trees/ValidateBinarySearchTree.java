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
    public class Pair{
        int min, max;
        boolean isBST;
        Pair(int a, int b, boolean c){
            min = a;
            max = b;
            isBST = c;
        }
    }

    public Pair helper(TreeNode root){
        if(root == null)
            return new Pair(0, 0, true);
        Pair pl = helper(root.left), pr = helper(root.right);
        if(root.left == null)
            pl.min = pl.max = root.val;
        if(root.right == null)
            pr.min = pr.max = root.val;
        Pair p = new Pair(pl.min, pr.max, pl.isBST && pr.isBST);
        if(root.left != null && pl.max >= root.val)
            p.isBST = false;
        if(root.right != null && pr.min <= root.val)
            p.isBST = false;
        return p;
    }
    
    public boolean isValidBST(TreeNode root) {
        Pair p = helper(root);
        return p.isBST;
    }
}
