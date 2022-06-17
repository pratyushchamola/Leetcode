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
    public ListNode mergesort(ListNode left,ListNode right){
        if(left == null)return right;
        if(right == null)return left;
        
        ListNode res = null;
        
        if(left.val <= right.val){
            res = left;
            res.next = mergesort(left.next,right);
        }else{
            res = right;
            res.next = mergesort(left,right.next);
        }
        
        return res;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)return null;
        
        ListNode cur = lists[0];
        
        for(int i=1;i<lists.length;i++){
            cur = mergesort(cur,lists[i]);
        }
        
        return cur;
    }
}