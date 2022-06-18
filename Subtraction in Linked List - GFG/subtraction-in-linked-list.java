// { Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}
// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    public static boolean borrow = false;
    static Node findsub(Node lnode,Node snode){
        if(lnode == null && snode == null && borrow == false)return lnode;
        
        Node prevnode = findsub(lnode.next,snode.next);
        
        // System.out.println(borrow);
        int ldata = lnode.data;
        int sdata = snode.data;
        if(borrow == true){
            if(ldata>0){
                ldata--;
                borrow = false;
            }
            else {
                borrow = true;
                ldata = 9;
            }
        }
        
        if(sdata > ldata){
            borrow = true;
            ldata = ldata + 10;
        }
        
        int sub = ldata - sdata;
        
        Node curnode = new Node(sub);
        
        curnode.next = prevnode;
        
        return curnode;
    }
    
    static Node addzeros(Node snode, int diff){
        if(snode == null)return snode;
        
        Node zero = new Node(0);
        Node toret = zero;
        diff--;
        
        while(diff-- != 0){
            zero.next = new Node(0);
            zero = zero.next;
        }
        
        zero.next = snode;
        
        return toret;
    }
    static Node subLinkedList(Node l1, Node l2)
    {
        // code here
        if(l1 == null)return l2;
        if(l2 == null)return l1;
        
        while(l1.next != null && l1.data == 0)l1 = l1.next;
        while(l2.next != null && l2.data == 0)l2 = l2.next;
        
        int l1size = 0, l2size = 0;
        Node l1cur = l1, l2cur = l2;
        Node cur1 = l1, cur2 = l2;
        
        while(l1cur != null){
            l1size++;
            l1cur = l1cur.next;
        }
        
        while(l2cur != null){
            l2size++;
            l2cur = l2cur.next;
        }
        
        Node lnode = null, snode = null;
        
        if(l1size != l2size){
            lnode = l1size > l2size ? l1 : l2;
            snode = l1size > l2size ? l2 : l1;
            
            int diff = Math.abs(l1size - l2size);
            
            snode = addzeros(snode,diff);
        }else{
            while(cur1 != null && cur2 != null){
                if(cur1.data != cur2.data){
                    lnode = cur1.data > cur2.data ? l1 : l2;
                    snode = cur1.data > cur2.data ? l2 : l1;
                    break;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            
            if(lnode == null){
                lnode = l1;
                snode = l2;
            }
        }
        
        
        Node toret = findsub(lnode,snode);
        
        while(toret.next != null && toret.data == 0)toret = toret.next;
        
        return toret;
        
    }
}