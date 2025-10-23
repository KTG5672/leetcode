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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode start = dummy;
        while(start != null) {
            swap(start);
            start = start.next;
            if (start == null) {
                break;
            }
            start = start.next;
        }
        return dummy.next;
    }

    private void swap(ListNode head) {
        ListNode n1 = head.next;
        ListNode n2 = head.next != null ? head.next.next : null;
        if (n1 == null || n2 == null) {
            return;
        }
        head.next = n2;
        n1.next = n2.next;
        n2.next = n1;
    }
}