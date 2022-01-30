/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;
        
        Map<Node, Node> ptrs = new HashMap<>();
        Node curr = head;
        while(curr != null){
            Node temp = new Node(curr.val);
            ptrs.put(curr, temp);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node temp = ptrs.get(curr);
            temp.next = ptrs.get(curr.next);
            temp.random = ptrs.get(curr.random);
            curr = curr.next;
        }
        return ptrs.get(head);
    }
}
