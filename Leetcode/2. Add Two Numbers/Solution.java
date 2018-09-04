/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 1. Adding a dummyHead will be easier for List operation.
         */
        ListNode dummyHead = new ListNode(0);
        ListNode work = dummyHead;
        /**
         * 2. Take care of carry bit.
         */
        int carry = 0;
        /**
         * 3. Both l1 and l2 contains digits.
         */
        while (l1 != null && l2 != null) {
            work.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            l1 = l1.next;
            l2 = l2.next;
            work = work.next;
        }
        /**
         * 4. Any of l1 or l2 will have remaining digits.
         */
        while (l1 != null) {
            work.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            l1 = l1.next;
            work = work.next;
        }
        while (l2 != null) {
            work.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            l2 = l2.next;
            work = work.next;
        }
        /**
         * 5. Don't forget to check the carry bit at the end.
         */
        if (carry != 0)
            work.next = new ListNode(carry);
        return dummyHead.next;
    }
}