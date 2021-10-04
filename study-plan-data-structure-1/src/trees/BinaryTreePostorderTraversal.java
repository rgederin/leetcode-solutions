package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 *
 * Algorithm Postorder(tree)
 *    1. Traverse the left subtree, i.e., call Postorder(left-subtree)
 *    2. Traverse the right subtree, i.e., call Postorder(right-subtree)
 *    3. Visit the root.
 */
public class BinaryTreePostorderTraversal {

    /**
     * Runtime: 1 ms, faster than 22.91% of Java online submissions for Binary Tree Postorder Traversal.
     * Memory Usage: 38.8 MB, less than 21.50% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderDFS(root, result::add);

        return result;
    }

    public void postorderDFS(TreeNode root, Consumer<Integer> action) {
        if (root == null) {
            return;
        }

        postorderDFS(root.left, action);
        postorderDFS(root.right, action);
        action.accept(root.val);
    }
}
