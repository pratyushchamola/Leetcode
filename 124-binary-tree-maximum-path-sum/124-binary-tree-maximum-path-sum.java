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
    public int answer;
    public int findans(TreeNode root){
        if(root == null)return -1001;
        
        int leftans = findans(root.left);
        int rightans = findans(root.right);
        
        int curans = root.val;
        
        curans = Math.max(curans,leftans + root.val);
        curans = Math.max(curans,rightans + root.val);
        
        answer = Math.max(curans,answer);
        answer = Math.max(answer,leftans + rightans + root.val);
        
        return curans;
        
        
    }
    public int maxPathSum(TreeNode root) {
        // return 0;
        answer = -1001;
        findans(root);
        
        return answer;
    }
}