/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        List<Node> arr = new ArrayList<>();
        //Map<Old, New>
        Map<Node, Node> hm = new HashMap<>();
        int count = 0;

        while (head != null) {
            Node tmp = new Node(head.val);
            tmp.next = head.next;
            tmp.random = head.random;
            arr.add(tmp);
            hm.put(head, tmp);
            count++;
            head = head.next;
        }

        for (Node n : arr) {
            n.next = hm.get(n.next);
            n.random = hm.get(n.random);
        }
        return arr.get(0);
    }
}
