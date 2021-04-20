package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Postorder
     * Traversal. Memory Usage: 37.2 MB, less than 65.00% of Java online submissions for Binary Tree
     * Postorder Traversal.
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
