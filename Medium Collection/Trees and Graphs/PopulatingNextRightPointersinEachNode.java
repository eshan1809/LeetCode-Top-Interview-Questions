/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        if(root.left == null && root.right == null)
            return root;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Node> list = new ArrayList<>();
            while(size-- > 0){
                Node rem = q.remove();
                list.add(rem);
                if(rem.left != null)
                    q.add(rem.left);
                if(rem.right != null)
                    q.add(rem.right);
            }
            for(int i = 0; i < list.size() - 1; i++)
                list.get(i).next = list.get(i + 1);
        }
        return root;
    }
}
