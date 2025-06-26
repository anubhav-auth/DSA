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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode l = null;
        ListNode r = head;
        ListNode temp = head.next;

        while(r != null){
            r.next = l;
            l = r;
            r = temp;
            if(temp != null)
                temp = temp.next;
        }
        return l;
    }
}