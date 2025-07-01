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
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;

        for(int i = 1; i < k; i++){
            lists[i] = mergeTwoLists(lists[i-1], lists[i]);
        }

        return lists[k-1];
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-101);
        ListNode temp = head;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2;

        return head.next;
    }
}