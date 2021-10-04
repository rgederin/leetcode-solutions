package trees;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Algorithm Preorder(tree)
 * 1. Visit the root.
 * 2. Traverse the left subtree, i.e., call Preorder(left-subtree)
 * 3. Traverse the right subtree, i.e., call Preorder(right-subtree)
 */

public class BinaryTreePreorderTraversal {

    /**
     * Runtime: 2 ms, faster than 19.19% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 38.6 MB, less than 31.83% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderDFS(root, result::add);

        return result;
    }

    public void preorderDFS(TreeNode root, Consumer<Integer> action) {
        if (root == null) {
            return;
        }

        action.accept(root.val);
        preorderDFS(root.left, action);
        preorderDFS(root.right, action);
    }
}