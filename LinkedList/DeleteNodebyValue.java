class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class LinkedList {

    static Node remove(Node head, int key) {

        if (head == null)
            return null;

        if (head.val == key)
            return head.next;

        Node prev = head;
        Node curr = head.next;

        while (curr != null && curr.val != key) {
            prev = curr;
            curr = curr.next;
        }

        if (curr != null)
            prev.next = curr.next;

        return head;
    }
}