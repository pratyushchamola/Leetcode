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
    public void findans(TreeNode root, List<Integer> arr){
        if(root == null)return;
        
        findans(root.left,arr);
        arr.add(root.val);
        findans(root.right,arr);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<Integer>();
        
        findans(root,arr);
        
        return arr;
    }
}