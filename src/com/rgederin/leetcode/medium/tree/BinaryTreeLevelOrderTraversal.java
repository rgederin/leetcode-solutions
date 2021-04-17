package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e.,
 * from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * Runtime: 3 ms, faster than 6.67% of Java online submissions for Binary Tree Level Order
     * Traversal. Memory Usage: 39.1 MB, less than 69.24% of Java online submissions for Binary Tree
     * Level Order Traversal
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        int h = height(root);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= h; i++) {
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
