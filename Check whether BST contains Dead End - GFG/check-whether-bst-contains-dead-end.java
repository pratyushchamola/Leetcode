// { Driver Code Starts
import java.util.Scanner;
import java.io.*;
class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }
class BinarySearchTree {
    public static Node root;
    BinarySearchTree() { 
        root = null; 
    }
    void insert(int key) {
       root = insertRec(root, key);
    }
    Node insertRec(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertRec(root.left, key);
        else if (key > root.data)
            root.right = insertRec(root.right, key);
        return root;
    }
 
    public static void inorder()  {
       inorderRec(root);
    }
    public static void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data);
            inorderRec(root.right);
        }
    }
 
    // Driver Program to test above functions
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int []a=new int[n];
            BinarySearchTree obj1=new BinarySearchTree();
            for(int i=0;i<n;i++)
            {
                int b=sc.nextInt();
                obj1.insert(b);
            }
            //inorder();
            GFG obj=new GFG();
            boolean k=obj.isDeadEnd(root);
            if(k==true)
            System.out.println("1");
            else
            System.out.println("0");
        }       
    }
}

// } Driver Code Ends


/*class Node {
        int data;
        Node left, right;
 
        Node(int item) {
            data = item;
            left = right = null;
        }
    }*/

//Function should return true if a deadEnd is found in the bst otherwise return false.
class GFG
{
    // public static boolean flag = true;
    public static boolean findans(Node root,int minval,int maxval){
        if(root == null)return false;
        
        if(root.right == null && root.left == null){
            if((root.data - minval) <= 1 && (maxval - root.data) <= 1){
                // flag = false;
                return true;
            }
        }
        
        boolean ans = false;
        ans = ans || findans(root.left,minval,root.data);
        ans = ans || findans(root.right,root.data,maxval);
        
        return ans;
        
    }
    public static boolean isDeadEnd(Node root)
    {
        //Add your code here.
        // flag = true;
        boolean ans = findans(root,1,Integer.MAX_VALUE);
        
        return ans;
    }
}