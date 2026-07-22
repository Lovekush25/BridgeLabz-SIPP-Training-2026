class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedList {

    static void insertAfter(Node current, int val) {
        if (current == null) return;

        Node newNode = new Node(val);
        newNode.next = current.next;
        current.next = newNode;
    }
}