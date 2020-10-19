import java.util.*;

/**
 *          12
 *          /\
 *         /  \
 *        7    1
 *        |    / \
 *        9   10  5
 *            / \
 *           20  17
 */
class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> nodesInCurrLevel = new ArrayList<>();
            for(int i=0; i<levelSize; i++){
                TreeNode curNode = q.poll();
                if(leftToRight){
                    nodesInCurrLevel.add(curNode.val);
                } else{
                    nodesInCurrLevel.add(0, curNode.val);
                }

                if(curNode.left != null){
                    q.offer(curNode.left);
                }
                if(curNode.right != null){
                    q.offer(curNode.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(nodesInCurrLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
