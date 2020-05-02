package com.rgederin.leetcode.utils;

import java.util.function.Consumer;

public final class DFSUtils {

    /**
     * In order depth first search traversal.
     *
     *    1. Recursively traverse the left subtree
     *    2. Visit the root.
     *    3. Recursively traverse the right subtree
     *
     * @param root - BST root node
     * @param action - action which needs to be done with element
     */
    public static void inorderDFS(TreeNode root, Consumer<TreeNode> action) {
        if (root == null) {
            return;
        }

        inorderDFS(root.left, action);
        action.accept(root);
        inorderDFS(root.right, action);
    }
}
