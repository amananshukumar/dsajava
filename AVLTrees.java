public class AVLTrees {
    static class Node {
        int data, height;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }          
    }

    static Node root;

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    public static Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        else 
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);
        if(balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }
        if(balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }
        if(balance > 1 && data > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balance < -1 && data < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public static Node rightRotate(Node node) {
        Node left = node.left;
        Node right = left.right;
        left.right = node;
        node.left = right;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        left.height = 1 + Math.max(height(left.left), height(left.right));
        return left;
    }

    public static Node leftRotate(Node node) {
        Node right = node.right;
        Node left = right.left;
        right.left = node;
        node.right = left;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        right.height = 1 + Math.max(height(right.left), height(right.right));
        return right;
    }

    public static void main(String[] args) {
        root= insert(root,10);
        root= insert(root,20);
        root= insert(root,30);
        root= insert(root,40);
        root= insert(root,50);
        root= insert(root,25);
    }
    
}
