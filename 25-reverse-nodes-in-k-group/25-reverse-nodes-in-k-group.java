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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null)return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, nex = dummy, cur = dummy;
        int size = 0;
        while(cur.next != null){
            size++;
            cur = cur.next;
        }
        
        while(size>=k){
            cur = prev.next;
            nex = cur.next;
                
            for(int i=1;i<k;i++){
                cur.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = cur.next;
            }
            size -= k;
            prev = cur;
        }
        
        return dummy.next;
    }
}