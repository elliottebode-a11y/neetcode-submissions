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
        arr.add(null);

        for (int i = 0; i < count; i++) {
            Node n = arr.get(i);
            n.next = hm.get(n.next);
            n.random = hm.get(n.random);
        }
        return arr.get(0);
    }
}
