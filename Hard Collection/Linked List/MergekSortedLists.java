/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    class Pair implements Comparable<Pair>{
        int val, idx;
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0), tmp = head;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int n = lists.length;
        for(int i = 0; i < n; i++){
            if(lists[i] != null){
                pq.add(new Pair(lists[i].val, i));
                lists[i] = lists[i].next;
            }
        }
        while(!pq.isEmpty()){
            Pair rem = pq.remove();
            tmp.next = new ListNode(rem.val);
            tmp = tmp.next;
            if(lists[rem.idx] != null){
                pq.add(new Pair(lists[rem.idx].val, rem.idx));
                lists[rem.idx] = lists[rem.idx].next;
            }
        }
        return head.next;
    }
}
