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
    public TreeNode findans(int[] preorder,int prestr,int preend,int[] postorder,int poststr,int postend){
        if(prestr > preend || poststr > postend)return null;
        
        TreeNode cur = new TreeNode(preorder[prestr]);
        if(prestr == preend)return cur;
        
        int ind = poststr;
        while(preorder[prestr+1] != postorder[ind])ind++;
        
        int lefttreecnt = ind - poststr + 1;
        
        cur.left = findans(preorder,prestr+1,prestr+lefttreecnt,postorder,poststr,ind);
        cur.right = findans(preorder,prestr+lefttreecnt+1,preend,postorder,ind+1,postend);
        
        return cur;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
     return findans(preorder,0,preorder.length-1,postorder,0,postorder.length);   
    }
}