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
        //Node tmpHead =

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
        hm.put(null, null);

        for (int i = 0; i < count; i++) {
            //next pointer is the index of the val
            Node n = arr.get(i);
            n.next = hm.get(n.next);
            //random pointer is the index of the val
            if (n.random != null) {
                n.random = hm.get(n.random);
            }
        }
        return arr.get(0);
    }
}
