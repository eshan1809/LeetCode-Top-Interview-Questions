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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)
            return list;
        Queue<TreeNode> q = new ArrayDeque<>();
        int level = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            while(size-- > 0){
                TreeNode rem = q.remove();
                al.add(rem.val);
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            if((level & 1) == 0)
                list.add(al);
            else{
                List<Integer> alr = new ArrayList<>();
                for(int i = al.size() - 1; i >= 0; i--)
                    alr.add(al.get(i));
                list.add(alr);
            }
            level++;
        }
        return list;
    }
}
