// { Driver Code Starts
import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Main {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            String[] ab = br.readLine().trim().split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);

            GfG g = new GfG();
            System.out.println(g.findDist(root, a, b));
        }
    }
}
// } Driver Code Ends


// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    // public int dist = 0;
    public Map<Integer,Integer> mp;
    public boolean find(Node root,int node){
        if(root == null)return false;
        
        if(root.data == node){
            // dist = curdist;
            mp.put(root.data,1);
            return true;
        }
        
        boolean flag = false;
        flag = flag || find(root.left,node);
        flag = flag || find(root.right,node);
        
        if(flag == true)mp.put(root.data,1);
        return flag;
        
    }
    
    public int ans = 0;
    public void findans(Node root,int b,int curdist){
        if(root == null)return;
        
        if(root.data == b){
            ans = curdist;
            
            // System.out.println("curdist : " + curdist + " ans root.data : " + root.data);
            return;
        }
        
        if(root.left != null){
            if(mp.containsKey(root.left.data) == true)findans(root.left,b,curdist-1);
            else findans(root.left,b,curdist+1);
        }
        
        if(root.right != null){
            if(mp.containsKey(root.right.data) == true)findans(root.right,b,curdist-1);
            else findans(root.right,b,curdist+1);
        }
        
    }
    int findDist(Node root, int a, int b) {
        // Your code here
        mp = new HashMap<Integer,Integer>();
        find(root,a);
        
        // for(Map.Entry<Integer,Integer> child : mp.entrySet()){
        //     System.out.println(child.getKey());
        // }
        
        // System.out.println("root dist : " + mp.size());
        findans(root,b,mp.size()-1);
        
        return ans;
        
    }
}