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
    public ListNode partition(ListNode head, int x) {
        ListNode a = new ListNode(0);
        ListNode b = new ListNode(0);
        ListNode cur1 = a;
        ListNode cur2 = b;
        ListNode cur = head;
        while(cur != null){
            int val = cur.val;
            
            if(val < x){
                cur1.next = cur;
                cur1 = cur1.next;
            }else {
                cur2.next = cur;
                cur2 = cur2.next;
            }
            
            cur = cur.next;
        }
        
        cur2.next = null;
        cur1.next = b.next;
        
        return a.next;
    }
}