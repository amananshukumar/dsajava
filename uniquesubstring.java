public class uniquesubstring {
    static class Node {
        Node child[] = new Node[26];
        boolean eow = false;
        public Node() {
            for (int i = 0; i < 26; i++) {
                child[i] = null;
            }
        }        
    }
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new Node();
            }
            curr = curr.child[idx];
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                return false;
            }
            curr = curr.child[idx];
        }
        return curr.eow==true;
    }

    public static int countNodes(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
           if(root.child[i] != null) {
               count += countNodes(root.child[i]);
           }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String str = "abcdeefg";
        int n = str.length();
        for (int i = 0; i < n; i++) {
           String suffix=str.substring(i,n); 
           insert(suffix);
        }
    }
}
