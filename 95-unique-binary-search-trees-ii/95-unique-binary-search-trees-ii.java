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
    public List<TreeNode> generateTrees(int n) {
        return findans(1,n);
    }
    
    public List<TreeNode> findans(int str,int ed){
        if(str > ed){
            List<TreeNode> cur = new ArrayList<TreeNode>();
            cur.add(null);
            return cur;
        }
        
        List<TreeNode> ans = new ArrayList<>();
        for(int i=str;i<=ed;i++){
            List<TreeNode> left = findans(str,i-1);
            List<TreeNode> right = findans(i+1,ed);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    
                    ans.add(root);
                }
            }
        }
        
        return ans;
    }
}