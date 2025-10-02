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
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(0);
        ListNode resultCursor = head;
        ListNode cursor1 = list1;
        ListNode cursor2 = list2;

        while (cursor1 != null || cursor2 != null) {
            if (cursor1 == null) {
                resultCursor.next = cursor2;
                cursor2 = cursor2.next;
            } else if (cursor2 == null) {
                resultCursor.next = cursor1;
                cursor1 = cursor1.next;
            } else if (cursor1.val <= cursor2.val) {
                resultCursor.next = cursor1;
                cursor1 = cursor1.next;
            } else {
                resultCursor.next = cursor2;
                cursor2 = cursor2.next;
            }
            resultCursor = resultCursor.next;
        }
        return head.next;
    }
}