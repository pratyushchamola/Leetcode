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
class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        st.push(cur);
        while(cur.left != null){
            st.push(cur.left);
            cur = cur.left;
        }
    }
    
    public int next() {
        TreeNode toret = st.pop();
        
        if(toret.right != null){
            st.push(toret.right);
            TreeNode cur = toret.right;
            while(cur.left != null){
                st.push(cur.left);
                cur = cur.left;
            }
        }
        
        return toret.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */