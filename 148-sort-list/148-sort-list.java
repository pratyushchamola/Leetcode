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
    public ListNode mergedlist(ListNode list1,ListNode list2){
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        
        if(list1.val > list2.val){
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        ListNode res = list1;
        while(list1 != null && list2 != null){
            ListNode t = list1;
            while(list1 != null && list1.val <= list2.val){
                t = list1;
                list1 = list1.next;
            }
            t.next = list2;
            
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        
        
        
        return res;
    }
    
    public ListNode findmid(ListNode head,ListNode tail){
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    
    public ListNode mergelist(ListNode head,ListNode tail){
        if(head == tail){
            // return head;
            ListNode curh = new ListNode();
            curh.val = head.val;
            return curh;
        }
        
        ListNode mid = findmid(head,tail);
        ListNode lans = mergelist(head,mid);
        ListNode rans = mergelist(mid.next,tail);
        
        // now we have two merged linked lists
        ListNode curans = mergedlist(lans,rans);
        
        return curans;
        // return lans;
    }
    
    
    public ListNode sortList(ListNode head) {
        if(head == null)return head;
        
        ListNode tail = head;
        
        while(tail.next != null)tail = tail.next;
        
        ListNode answer = mergelist(head,tail);
        
        return answer;
    }
}