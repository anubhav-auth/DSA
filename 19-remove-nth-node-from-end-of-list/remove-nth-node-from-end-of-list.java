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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dum = new ListNode(0);
        dum.next = head;

        ListNode f = dum;
        ListNode s = dum;

        for(int i = 0; i <= n; i++){
            f = f.next;
        }

        while(f != null){
            f = f.next;
            s = s.next;
        }

        s.next = s.next.next;
        return dum.next;
    }
}