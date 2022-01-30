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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = midOfList(head), nhead = mid.next;
        mid.next = null;
        return mergeSortedLists(sortList(head), sortList(nhead));
    }
    
    private ListNode midOfList(ListNode head){
        ListNode s = head, f = head;
        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
    
    private ListNode mergeSortedLists(ListNode h1, ListNode h2){
        ListNode head = new ListNode(0), tmp = head;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                tmp.next = h1;
                h1 = h1.next;
            } else{
                tmp.next = h2;
                h2 = h2.next;
            }
            tmp = tmp.next;
        }
        while(h1 != null){
            tmp.next = h1;
            h1 = h1.next;
            tmp = tmp.next;
        }
        while(h2 != null){
            tmp.next = h2;
            h2 = h2.next;
            tmp = tmp.next;
        }
        tmp.next = null;
        return head.next;
    }
}
