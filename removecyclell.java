class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class removecyclell {

    static void removeCycle(Node head) {
        Node slow = head;
        Node fast = head;

        // Step 1: Detect cycle
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle) return;

        // Step 2: Find start of cycle
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        // Step 3: Remove cycle
        fast.next = null;
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Creating cycle
        head.next.next.next.next = head.next;

        removeCycle(head);

        // Print list
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}