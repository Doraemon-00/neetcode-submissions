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
        Map<Node, Node> pairs = new HashMap<>();

        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            pairs.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            Node copy = pairs.get(curr);
            copy.next = pairs.get(curr.next);
            copy.random = pairs.get(curr.random);
            curr = curr.next;
        }

        return pairs.get(head);
    }
}
