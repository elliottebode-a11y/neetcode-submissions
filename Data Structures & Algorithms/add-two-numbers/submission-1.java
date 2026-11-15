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
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + carry;
            ListNode tmp = new ListNode(num % 10);
            carry = num / 10;
            tail.next = tmp;
            tail = tail.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = l1.val + carry;
            ListNode tmp = new ListNode(num % 10);
            carry = num / 10;
            tail.next = tmp;
            tail = tail.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = l2.val + carry;
            ListNode tmp = new ListNode(num % 10);
            carry = num / 10;
            tail.next = tmp;
            tail = tail.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            tail.next = new ListNode(carry);
        }
        return head.next;
    }
}
