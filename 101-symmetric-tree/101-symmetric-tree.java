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
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        Queue<TreeNode> leftqueue = new LinkedList<>();
        Queue<TreeNode> rightqueue = new LinkedList<>();
        
        leftqueue.add(root.left);
        rightqueue.add(root.right);
        
        while(leftqueue.size()>0 && rightqueue.size()>0){
            TreeNode curleft = leftqueue.peek();
            TreeNode curright = rightqueue.peek();
            
            leftqueue.remove();
            rightqueue.remove();
            
            if(curleft == null && curright == null)continue;
            if(curleft == null || curright == null)return false;
            if(curleft.val != curright.val)return false;
            
            leftqueue.add(curleft.left);
            leftqueue.add(curleft.right);
            
            rightqueue.add(curright.right);
            rightqueue.add(curright.left);
        }
        
        return true;
    }
}