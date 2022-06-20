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
    public int sum = 0;
    public boolean flag = false;
    
    public void dfs(TreeNode root,int targetsum){
        if(root.left == null && root.right == null){
            if(sum+root.val == targetsum){
                flag = flag || true;
                // return;
            }
            return;
        }
        
        sum += root.val;
        int cursum = sum;
        if(root.left != null)dfs(root.left,targetsum);
        sum = cursum;
        if(root.right != null)dfs(root.right,targetsum);
        sum = cursum;
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // int sum = root.val;
        if(root == null)return false;
        
        dfs(root,targetSum);
        
        return flag;
    }
}