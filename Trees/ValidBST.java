public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
       }
    
       // pass in allowed range for root
    public boolean helper(TreeNode root, Integer lower, Integer upper) {
        if(root == null) return true;
        
        if( lower != null && root.val <= lower) return false;
        if( upper != null && root.val >= upper) return false;
        
        return helper(root.left, lower, root.val) && helper(root.right, root.val, upper); 
    }
}
