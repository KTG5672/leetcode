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
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode merged = merge(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            merged = merge(merged, lists[i]);
        }
        return merged;
    }

    ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        ListNode result = new ListNode(0);
        ListNode resultHead = result;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                result.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                result.next = head1;
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                result.next = head2;
                head2 = head2.next;
            } else {
                result.next = head1;
                head1 = head1.next;
            }
            result = result.next;
        }

        return resultHead.next;
    }
}