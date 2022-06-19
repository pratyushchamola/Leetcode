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
    public List<String> ans = new ArrayList<>();
    
    public void dfs(TreeNode node, StringBuilder sb){
        if(node == null)return;
        
        int len = sb.length();
        sb.append(node.val);
        
        if(node.left == null && node.right == null){
            ans.add(sb.toString());
        }else{
            sb.append("->");
            dfs(node.left,sb);
            dfs(node.right,sb);
        }
        sb.setLength(len);
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root,new StringBuilder());
        
        return ans;
    }
}