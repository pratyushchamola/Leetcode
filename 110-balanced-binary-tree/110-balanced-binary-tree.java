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
    boolean flag = true;
    public int findans(TreeNode root){
        if(root == null)return 0;
        if(root.right == null && root.left == null)return 1;
        
        int leftans = findans(root.left);
        int rightans = findans(root.right);
        
        if(Math.abs(leftans - rightans) > 1){
            flag = flag && false;
        }
        
        return Math.max(leftans,rightans) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        int ans = findans(root);
        
        return (flag == true);
    }
}