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
    public ListNode reorderList(ListNode head) {
        if(head.next == null) return head;

        ListNode s = head; // mid
        ListNode f = head;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }

        ListNode n = reverseList(s.next);
        s.next = null;

        return mergeTwoLists(head, n);
    }

    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101); //dummy wil return head.next
        ListNode temp = head;

        int a = 1;
        
        while(list1 != null && list2 != null){
            if(a%2 != 0){
                temp.next = list1;
                list1 = list1.next;
                a++;
            }else{
                temp.next = list2;
                list2 = list2.next;
                a++;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2;

        return head.next;
    }
}