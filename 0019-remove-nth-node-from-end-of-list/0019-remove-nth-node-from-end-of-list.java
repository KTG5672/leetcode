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
        ListNode result = new ListNode(0, head);
        ListNode cursor = head;
        int size = 1;
        while (cursor.next != null) {
            cursor = cursor.next;
            size++;
        }
        int targetPre = size - n;
        cursor = result;
        for (int i = 0; i < targetPre; i++) {
            cursor = cursor.next;
        }
        if (cursor.next != null) {
            cursor.next = cursor.next.next;
        }
        return result.next;
    }
}