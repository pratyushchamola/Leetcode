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
    public class Helper{
        boolean hasCamera;
        boolean isCovered;
        int minCameras;
        
        Helper(int a,boolean b,boolean c){
            minCameras = a;
            isCovered = b;
            hasCamera = c;
        }
    }
    
    public Helper findans(TreeNode root){
        if(root == null)return new Helper(0,true,false);
        
        Helper lr = findans(root.left);
        Helper rr = findans(root.right);
        
        if(!lr.isCovered || !rr.isCovered){
            return new Helper(lr.minCameras + rr.minCameras + 1,true,true);
        }
        
        if(lr.hasCamera || rr.hasCamera){
            return new Helper(lr.minCameras + rr.minCameras,true,false);
        }else{
            return new Helper(lr.minCameras + rr.minCameras,false,false);
        }
    }
    public int minCameraCover(TreeNode root) {
        Helper ans = findans(root);
        
        if(!ans.isCovered)return ans.minCameras + 1;
        else return ans.minCameras;
    }
}