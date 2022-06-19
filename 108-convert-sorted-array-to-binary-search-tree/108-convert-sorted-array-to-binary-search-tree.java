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
    public static TreeNode findans(int[] arr,int str,int ed){
        if(str>ed)return null;
        int mid = (ed+str)/2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = findans(arr,str,mid-1);
        node.right = findans(arr,mid+1,ed);
        
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return findans(nums,0,nums.length-1);
    }
}