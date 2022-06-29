/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode first,last,middle,prev;
    
    public void findans(TreeNode root){
        if(root == null)return;
        
        // first go to left, and find minimum (as done in inroder)
        findans(root.left);
        
        // there can be two cases, either the swapped numbers are adjacent to each other (in inorder sequence, or are far apart)
        if((prev != null) && root.val < prev.val){
            
            // first and middle handles the case of neighbor swapped numbers
            if(first == null){
                first = prev;
                middle = root;
                // last is for handling distant swapped numbers, if any
            }else last = root;
        }
        
        prev = root;
        
        findans(root.right);
    }
    public void recoverTree(TreeNode root) {
        
        first = last = middle = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        
        // initiate an inroder
        findans(root);
        
        if(first != null && last != null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }else if(first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
    }
}