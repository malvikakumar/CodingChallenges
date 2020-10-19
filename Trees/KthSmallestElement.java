import java.util.*;

public class KthSmallestElement {
    ArrayList<Integer> l = new ArrayList<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        inorder(root);
        return l.get(k-1);
    }
    
    public void inorder(TreeNode root) {
        if(root == null) {return;}
        inorder(root.left);
        l.add(root.val);
        inorder(root.right);
        
    }
}
