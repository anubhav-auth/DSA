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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        ListNode s = head, f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        ListNode n = reverseList(s.next);
        s.next = null;

        f = head;
        while (n != null) {
            ListNode tmp1 = f.next;
            ListNode tmp2 = n.next;

            f.next = n;
            n.next = tmp1;

            f = tmp1;
            n = tmp2;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }
}