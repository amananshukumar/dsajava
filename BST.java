
import java.util.*;

public class BST {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            
        }
    }
    public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=insert(root.left,data);
        }
        else{
            root.right=insert(root.right,data);
        }
        return root;
    }

    public static boolean search(Node root,int key){
        if(root==null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(key<root.data){
            return search(root.left,key);
        }
        else{
            return search(root.right,key);
        }
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);
    }

    public static Node delete(Node root,int key){
        if(root.data<key){
            root.right=delete(root.right,key);
        }
        else if(root.data>key){
            root.left=delete(root.left,key);
        }
        else{
            if(root.left==null && root.right==null){
                return null;
            }
            else if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            Node IS= findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
    
    public static void printINRange(Node root,int k1,int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printINRange(root.left,k1,k2);
            System.out.print(root.data+" ");
            printINRange(root.right,k1,k2);
        }
        else if(root.data<k1){
            printINRange(root.left,k1,k2);
        }
        else{
            printINRange(root.right,k1,k2);
        }
    }

    public static void printpath(ArrayList<Integer> path){
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println("null");
    }

    public static void printRoot2leaf(Node root,ArrayList<Integer> path){
        if(root==null){
            return;
        } 
        path.add(root.data);
        if(root.left==null && root.right==null){
            printpath(path);
            return;
        }
        printRoot2leaf(root.left, path);
        printRoot2leaf(root.right, path);
        path.remove(path.size()-1);
        
    }

    public static boolean isValidBst(Node root,Node min,Node max){
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return isValidBst(root.left,min,root) && isValidBst(root.right,root,max);

    }

    
    public static void main(String[] args) {
        int nodes[]={5,1,3,4,2,7};
        Node root=null;
        for(int i=0;i<nodes.length;i++){
            root=insert(root,nodes[i]);
        }
    
    inorder(root);
    System.out.println(root.data);
    

    if(search(root,3)){
        System.out.println("found");
    }
    else{
        System.out.println("not found");
    }
}
}
