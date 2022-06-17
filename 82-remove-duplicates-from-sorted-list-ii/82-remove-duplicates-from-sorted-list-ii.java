/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Stack<ListNode> st = new Stack<ListNode>();
        
        ListNode cur = head;
        
        ListNode toret = head;
        while(cur != null){
            if(!st.isEmpty() && st.peek().val == cur.val){
                while(cur != null && st.peek().val == cur.val)cur = cur.next;
                st.pop();
                
                if(st.isEmpty()){
                    toret = cur;
                }else st.peek().next = cur;
                st.push(cur);
            }else st.push(cur);
            
            if(cur != null)cur = cur.next;
            
        }
        
        return toret;
    }
}