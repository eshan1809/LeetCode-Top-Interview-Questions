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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1 = list1, t2 = list2, list = new ListNode(0), t = list;
        while(t1 != null && t2 != null){
            if(t1.val < t2.val){
                t.next = new ListNode(t1.val);
                t = t.next;
                t1 = t1.next;
            } else{
                t.next = new ListNode(t2.val);
                t = t.next;
                t2 = t2.next;
            }
        }
        while(t1 != null){
            t.next = new ListNode(t1.val);
            t = t.next;
            t1 = t1.next;
        }
        while(t2 != null){
            t.next = new ListNode(t2.val);
            t = t.next;
            t2 = t2.next;
        }
        return list.next;
    }
}
