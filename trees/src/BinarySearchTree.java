public class BinarySearchTree {
    class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    Node search(int key) {
        return searchRec(root, key);
    }

    Node searchRec(Node root, int key) 
{ 
    if (root==null || root.key==key) 
        return root;   
    if (root.key > key) 
        return searchRec(root.left, key); 
    return searchRec(root.right, key); 
} 

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

    /* Let us create following BST
        50
    /	 \
    30	 70
    / \ / \
20 40 60 80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(tree.search(20));
        System.out.println(tree.search(90));

        tree.inorder();
    }
}

//TC: Avg: O(log n), Worst: O(n) for all operations, SC: O(n)
