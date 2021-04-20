package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;


/**
 * 94. Binary Tree Inorder Traversal
 */
public class BinaryTreeInorderTraversal {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder
     * Traversal. Memory Usage: 36.9 MB, less than 91.03% of Java online submissions for Binary Tree
     * Inorder Traversal.
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
