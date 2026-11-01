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
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        //idea is to maintain a pq of nodes and link them
        //easiest to keep the head of each list in pq
        //want to 
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (ListNode node : lists) {
            if (node != null) minHeap.offer(node);
        }
        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            if (next.next != null) minHeap.offer(next.next);
            cur.next = next;
            cur = next;
        }
        return head.next;
    }
}
