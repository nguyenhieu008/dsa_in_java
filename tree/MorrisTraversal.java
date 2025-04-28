package tree;

/**
 * Implementation of Morris Traversal algorithms for binary trees
 */
/**
 * Implementation of Morris Traversal algorithms for binary trees
 */
public class MorrisTraversal {

    // Node class for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Morris Inorder Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void morrisInorderTraversal(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            // If left child is null, print the current node and move to right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor (rightmost node in left subtree)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // If right pointer of predecessor is null, point it to current and move left
                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                }
                // If right pointer points to current, undo the changes and visit current
                else {
                    predecessor.right = null;
                    System.out.print(current.val + " ");
                    current = current.right;
                }
            }
        }
    }

    /**
     * Morris Preorder Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void morrisPreorderTraversal(TreeNode root) {
        TreeNode current = root;

        while (current != null) {
            // If left child is null, print the current node and move to right
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                // Find the inorder predecessor (rightmost node in left subtree)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                // If right pointer of predecessor is null, print current, point it to current and move left
                if (predecessor.right == null) {
                    System.out.print(current.val + " ");
                    predecessor.right = current;
                    current = current.left;
                }
                // If right pointer points to current, undo the changes and move right
                else {
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    /**
     * Morris Postorder Traversal
     * This is more complex - using a reverse approach with temporary dummy root
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void morrisPostorderTraversal(TreeNode root) {
        // Create a dummy node and make the original tree its left child
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode current = dummy;

        while (current != null) {
            if (current.left == null) {
                current = current.right;
            } else {
                // Find inorder predecessor
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Print values in reverse order from left child to predecessor
                    printReverse(current.left, predecessor);
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }

    // Helper function for postorder traversal
    private static void printReverse(TreeNode from, TreeNode to) {
        // Reverse the right pointers
        reverseRightPointers(from, to);

        // Print values from 'to' to 'from'
        TreeNode current = to;
        while (true) {
            System.out.print(current.val + " ");
            if (current == from) {
                break;
            }
            current = current.right;
        }

        // Restore the right pointers
        reverseRightPointers(to, from);
    }

    // Helper function to reverse right pointers
    private static void reverseRightPointers(TreeNode from, TreeNode to) {
        TreeNode a = from;
        TreeNode b = a.right;

        while (a != to) {
            TreeNode c = b.right;
            b.right = a;
            a = b;
            b = c;
        }
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Morris Inorder Traversal:");
        morrisInorderTraversal(root);
        System.out.println("\n");

        System.out.println("Morris Preorder Traversal:");
        morrisPreorderTraversal(root);
        System.out.println("\n");

        System.out.println("Morris Postorder Traversal:");
        morrisPostorderTraversal(root);
        System.out.println("\n");
    }
}
