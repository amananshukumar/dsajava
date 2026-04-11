import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class mergesortll {

    Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node mid = findMid(head);
        Node left = mid.next;
        mid.next = null;

        Node right = mergesort(left);
        Node newLeft = mergesort(head);

        return merge(newLeft, right);
    }

    private Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node left, Node right) {
        Node res = new Node(0);
        Node temp = res;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }

        if (left != null)
            temp.next = left;
        else
            temp.next = right;

        return res.next;
    }

    void print(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        mergesortll obj = new mergesortll();

        Node head = new Node(5);
        head.next = new Node(1);
        head.next.next = new Node(4);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(3);

        obj.print(head);

        head = obj.mergesort(head);

        obj.print(head);
    }
}