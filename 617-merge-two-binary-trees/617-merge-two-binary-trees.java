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
    TreeNode findans(TreeNode a,TreeNode b){
        if(a == null && b == null)return null;
        
        int one = (a != null) ? a.val : 0;
        int two = (b != null) ? b.val : 0;
        
        TreeNode cur = new TreeNode(one + two);
        
        cur.left = findans(a == null ? null : a.left,b == null ? null : b.left);
        cur.right = findans(a == null ? null : a.right,b == null ? null : b.right);
        
        return cur;
        
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return findans(root1,root2);
    }
}