/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static HashMap<Node,Node> check = new HashMap<Node,Node>();
    
    public void helperfunct(Node head){
        if(head == null)return;
        Node newnode = new Node(head.val);
        check.put(head,newnode);
        
        helperfunct(head.next);
    }
    
    public Node copyRandomList(Node head) {
        helperfunct(head);
        Node curnode = head;
        
        while(curnode != null){
            if(curnode.next != null)check.get(curnode).next = check.get(curnode.next);
            if(curnode.random != null)check.get(curnode).random = check.get(curnode.random);
            
            curnode = curnode.next;
        }
        
        return check.get(head);
        
    }
}