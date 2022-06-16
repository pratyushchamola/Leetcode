/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Stack<Node> st = new Stack<Node>();
        
        Node cur = head;
        
        while(cur != null){
            if(cur.child != null){
                if(cur.next != null)st.push(cur.next);
                
                cur.next = cur.child;
                cur.next.prev = cur;
                cur.child = null;
            }
            
            if(cur.next == null && !st.empty()){
                Node curnode = st.pop();
                cur.next = curnode;
                cur.next.prev = cur;
            }
            cur = cur.next;
        }
        
        return head;
    }
}