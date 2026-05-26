import java.lang.reflect.Array;
import java.util.ArrayList;

public class covertTOBalancedBST {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void getinorder(Node root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        getinorder(root.left, list);
        list.add(root.data);
        getinorder(root.right, list);
        list.add(root.data);
    
    }

    public static Node createBST(ArrayList<Integer> list, int s, int e) {
        if (s > e) {
            return null;
        }
        int mid = (s + e) / 2;
        Node root = new Node(list.get(mid));
        root.left = createBST(list, s, mid - 1);
        root.right = createBST(list, mid + 1, e);
        return root;
    }

    public static Node balencedBST(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        getinorder(root, list);

        root = createBST(list, 0, list.size() - 1);

        return root;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root = balencedBST(root);
        preorder(root);

    }
}