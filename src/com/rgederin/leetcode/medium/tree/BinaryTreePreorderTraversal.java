package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 144. Binary Tree Preorder Traversal
 */
public class BinaryTreePreorderTraversal {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder
     * Traversal. Memory Usage: 36.9 MB, less than 97.00% of Java online submissions for Binary Tree
     * Preorder Traversal.
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
