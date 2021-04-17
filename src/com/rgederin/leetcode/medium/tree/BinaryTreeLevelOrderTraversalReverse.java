package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (i.e., from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversalReverse {

    /**
     * Runtime: 3 ms, faster than 7.11% of Java online submissions for Binary Tree Level Order
     * Traversal II. Memory Usage: 39.4 MB, less than 26.32% of Java online submissions for Binary
     * Tree Level Order Traversal II.
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int h = height(root);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = h - 1; i >= 0; i--) {
            List<Integer> list = new ArrayList<>();

            visitLevel(root, i, list);

            result.add(list);
        }

        return result;
    }

    /**
     * Compute the "height" of a tree -- the number of nodes along the longest path from the root
     * node down to the farthest leaf node.
     */
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lheight = height(root.left);
            int rheight = height(root.right);

            /* use the larger one */
            return lheight > rheight ? lheight + 1 : rheight + 1;
        }
    }

    /* Visit nodes at the given level */
    void visitLevel(TreeNode root, int level, List<Integer> list) {
        if (root == null) {
            return;
        }

        if (level == 1) {
            list.add(root.val);
        } else if (level > 1) {
            visitLevel(root.left, level - 1, list);
            visitLevel(root.right, level - 1, list);
        }
    }
}
