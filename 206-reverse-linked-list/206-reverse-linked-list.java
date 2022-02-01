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
    public ListNode getnode(int curind,ListNode cn){
        ListNode temp = new ListNode();
        temp = cn;
        
        for(int i=0;i<curind;i++){
            temp = temp.next;
        }
        
        return temp;
    }
    public ListNode reverseList(ListNode head) {
        ListNode curnode = new ListNode();
        curnode = head;
        int size = 0;
        
        while(curnode != null){
            size++;
            curnode = curnode.next;
        }
        
        int l = 0;
        int r = size-1;
        
        while(l < r){
            ListNode lef = getnode(l,head);
            ListNode rig = getnode(r,head);
            
            int temp = lef.val;
            lef.val = rig.val;
            rig.val = temp;
            
            l++;
            r--;
        }
        
        
        return head;
    }
}