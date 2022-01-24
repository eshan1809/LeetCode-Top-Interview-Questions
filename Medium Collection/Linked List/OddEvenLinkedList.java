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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;
        ListNode even = head.next, et = even, ot = head;
        ot.next = ot.next.next;
        ot = ot.next;
        while(ot.next != null){
            et.next = ot.next;
            et = et.next;
            ot.next = ot.next.next;
            if(ot.next != null)
                ot = ot.next;
        }
        et.next = null;
        ot.next = even;
        return head;
    }
}
