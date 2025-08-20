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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode head = result;
        ListNode l1Iterator = l1;
        ListNode l2Iterator = l2;
        int nextPlus = 0;
        while (l1Iterator != null || l2Iterator != null || nextPlus != 0) {
            int sum = (l1Iterator == null ? 0 : l1Iterator.val) + (l2Iterator == null ? 0 : l2Iterator.val);
            int val = (sum + nextPlus) % 10;
            nextPlus = (sum + nextPlus) / 10;
            l1Iterator = l1Iterator == null ? null : l1Iterator.next;
            l2Iterator = l2Iterator == null ? null : l2Iterator.next;
            head.next = new ListNode(val);
            head = head.next;
        }

        return result.next;
    }
}