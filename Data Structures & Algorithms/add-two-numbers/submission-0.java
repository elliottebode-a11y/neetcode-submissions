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
        int pow = 0;
        int num1 = 0;
        int carry = 0;
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (l1 != null || l2 != null) {
            if (l1 == null) l1 = new ListNode(0);
            if (l2 == null) l2 = new ListNode(0);
            int eNum = carry + l1.val + l2.val;
            carry = (eNum) / 10;
            ListNode tmp = new ListNode(eNum % 10);
            head.next = tmp;
            head = tmp;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
