package Graphs;
import java.util.*;

// Diameter of undirected tree or graph
public class DiameterOfBinaryTree {
    static int maxDiameter;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4),new TreeNode(5)),new TreeNode(3));
        System.out.println(diameterOfBinaryTree(root));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 1;
        depth(root);
        return maxDiameter-1;
    }
    public static int depth(TreeNode root) {
        if(root == null) return 0;
        int leftD = depth(root.left);
        int rightD = depth(root.right);
        maxDiameter = Math.max(maxDiameter,leftD+rightD+1);
        return Math.max(leftD,rightD)+1;
    }
}

class TreeNode {
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