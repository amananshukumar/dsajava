import java.util.*;
public class mirrorBst {
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
    public static Node createmirror(Node root){
        if(root==null){
            return null;
        }
        createmirror(root.left);
        createmirror(root.right);
        Node leftmirror= createmirror(root.left);
        Node rightmirror= createmirror(root.right);
        root.left=rightmirror;
        root.right=leftmirror;
        return root;
        
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        createmirror(root);
        inorder(root);
    }
}
