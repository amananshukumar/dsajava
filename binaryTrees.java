import java.util.*;

public class binaryTrees {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    static class BinaryTree {

        static int idx = -1;

        public static Node buildTree(int nodes[]) {

            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // Preorder Traversal
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Inorder Traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // Postorder Traversal
    public static void postorder(Node root) {
        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal
    public static void levelorder(Node root) {
        if (root == null) {
            return;
        }

        Queue<Node> q = new LinkedList<>();

        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {

            Node currNode = q.remove();

            if (currNode == null) {

                System.out.println();

                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }

            } else {

                System.out.print(currNode.data + " ");

                if (currNode.left != null) {
                    q.add(currNode.left);
                }

                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Height of Tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return 1 + Math.max(lh, rh);
    }

    // Count Nodes
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int lc = count(root.left);
        int rc = count(root.right);

        return 1 + lc + rc;
    }

    // Sum of Nodes
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);

        return root.data + ls + rs;
    }

    // Diameter O(n^2)
    public static int diameter(Node root) {

        if (root == null) {
            return 0;
        }

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter,
                Math.max(leftDiameter, rightDiameter));
    }

    // Diameter O(n)
    public static Info diameter2(Node root) {

        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int diam = Math.max(
                Math.max(leftInfo.diam, rightInfo.diam),
                leftInfo.ht + rightInfo.ht + 1);

        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    // Check identical trees
    public static boolean isIdentical(Node root1, Node root2) {

        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.data != root2.data) {
            return false;
        }

        return isIdentical(root1.left, root2.left)
                && isIdentical(root1.right, root2.right);
    }

    // Check subtree
    public static boolean isSubtree(Node root, Node subRoot) {

        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    static class Infoo {
        Node node;
        int hd;

        public Infoo(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Kth Level
    public static void Klevel(Node root, int level, int k) {

        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        Klevel(root.left, level + 1, k);
        Klevel(root.right, level + 1, k);
    }

    // Get Path
    public static boolean getPath(Node root, int n,
            ArrayList<Node> path) {

        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundleft = getPath(root.left, n, path);
        boolean foundright = getPath(root.right, n, path);

        if (foundleft || foundright) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    public static int lcadistance(Node root, int n1, int n2) {
        if (root == null) {
            return -1;
        }

        if (root.data == n1) {
            return 0;
        }

        int left = lcadistance(root.left, n1, n2);
        int right = lcadistance(root.right, n1, n2);

        if (left == -1 && right == -1) {
            return -1;
        } else if (left == -1) {
            return right + 1;
        } else if (right == -1) {
            return left + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static int minDistance(Node root, int n1, int n2) {
        Node lca= lca(root, n1, n2);
        int d1 = lcadistance(root, n1, lca.data);
        int d2 = lcadistance(root, n2, lca.data);
        return d1 + d2;
    }

    // Lowest Common Ancestor
    public static Node lca(Node root, int n1, int n2) {

        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        int i = 0;

        for (; i < Math.min(path1.size(), path2.size()); i++) {

            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        return path1.get(i - 1);
    }

    public static Node lca2(Node root, int n1, int n2) {

        if (root == null) {
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node left = lca2(root.left, n1, n2);
        Node right = lca2(root.right, n1, n2);
        if(right == null) {
            return left;
        }
        if(left == null) {
            return right;
        }
        return root;
    }

    public static int Kancestor(Node root, int n, int k) {
        if(root.data ==n){
            return 0;
        }

        int left = Kancestor(root.left, n, k);
        int right = Kancestor(root.right, n, k);

        if(left == -1 && right == -1){
            return -1;
        }

        int max = Math.max(left, right);

        if(max + 1 == k){
            System.out.println(root.data);
        }
        return max + 1;
    }

    // Top View
    public static void topView(Node root) {

        Queue<Infoo> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0;
        int max = 0;

        q.add(new Infoo(root, 0));

        while (!q.isEmpty()) {

            Infoo curr = q.remove();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node);
            }

            if (curr.node.left != null) {
                q.add(new Infoo(curr.node.left, curr.hd - 1));
                min = Math.min(min, curr.hd - 1);
            }

            if (curr.node.right != null) {
                q.add(new Infoo(curr.node.right, curr.hd + 1));
                max = Math.max(max, curr.hd + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }

        System.out.println();
    }



    public static int transform(Node root) {

        if (root == null) {
            return 0;
        }
        int left = transform(root.left);
        int right = transform(root.right);

        int data = root.data;

        int newLeft= root.left == null ? 0 : root.left.data + left + right;
        int newRight= root.right == null ? 0 : root.right.data + left + right;

        root.data= newLeft + newRight+left+right;

        return data;
    }

    

    public static void main(String[] args) {

        int nodes[] = {
                1,
                2,
                4,
                -1,
                -1,
                5,
                -1,
                -1,
                3,
                -1,
                6,
                -1,
                -1
        };

        BinaryTree tree = new BinaryTree();

        Node root = tree.buildTree(nodes);

        System.out.println("Preorder:");
        preorder(root);

        System.out.println("\n\nInorder:");
        inorder(root);

        System.out.println("\n\nPostorder:");
        postorder(root);

        System.out.println("\n\nLevel Order:");
        levelorder(root);

        System.out.println("\nHeight = " + height(root));

        System.out.println("Count = " + count(root));

        System.out.println("Sum = " + sum(root));

        System.out.println("Diameter = " + diameter(root));

        Info info = diameter2(root);
        System.out.println("Optimized Diameter = " + info.diam);

        System.out.println("\nKth Level:");
        Klevel(root, 1, 2);

        Node ans = lca(root, 4, 5);
        System.out.println("\n\nLCA of 4 and 5 = " + ans.data);

        System.out.println("\nTop View:");
        topView(root);
    }
}