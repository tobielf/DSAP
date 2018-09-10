/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /** 1. Add a dummy head, unify the operations on all lists */
        ListNode dummy = new ListNode(0);
        ListNode nth_node = head;
        ListNode delete_node = dummy;
        dummy.next = head;

        /** 2. Move nth node pointer first */
        while (n > 0 && nth_node != null) {
            nth_node = nth_node.next;
            n--;
        }

        /** 3. Move the delete node and nth node togeter, the delete node will point at one element ahead of
         * the node going to delete, once the nth node reached the end */
        while (nth_node != null) {
            nth_node = nth_node.next;
            delete_node = delete_node.next;
        }

        delete_node.next = delete_node.next.next;
        return dummy.next;
    }
}