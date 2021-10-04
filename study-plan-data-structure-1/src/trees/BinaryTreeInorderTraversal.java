package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 94. Binary Tree Inorder Traversal (easy)
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 * Algorithm Inorder(tree)
 *    1. Traverse the left subtree, i.e., call Inorder(left-subtree)
 *    2. Visit the root.
 *    3. Traverse the right subtree, i.e., call Inorder(right-subtree)
 */
public class BinaryTreeInorderTraversal {

    /**
     * Runtime: 1 ms, faster than 18.42% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 39.2 MB, less than 5.71% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderDFS(root, result::add);

        return result;
    }

    public void inorderDFS(TreeNode root, Consumer<Integer> action) {
        if (root == null) {
            return;
        }

        inorderDFS(root.left, action);
        action.accept(root.val);
        inorderDFS(root.right, action);
    }
}
