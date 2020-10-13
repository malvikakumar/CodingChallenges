package Trees;

// Need to valodate this solution
public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            if( root.val >= root.right.val) return false;
        }
        if (root.right != null) {
            if(root.left.val >= root.val) return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
