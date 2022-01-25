/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        StringBuilder sb = new StringBuilder();
        for(int i : list)
            sb.append(i + " ");
        return sb.toString();
    }
    
    public void preOrder(TreeNode root, List<Integer> list){
        if(root == null){
            list.add(1001);
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] parts = data.split(" ");
        int n = parts.length;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(parts[i]);
        return build(arr, new int[1]);
    }
    
    public TreeNode build(int[] arr, int[] idx){
        if(arr[idx[0]] == 1001){
            idx[0]++;
            return null;
        }
        TreeNode root = new TreeNode(arr[idx[0]++]), left = build(arr, idx), right = build(arr, idx);
        root.left = left;
        root.right = right;
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
