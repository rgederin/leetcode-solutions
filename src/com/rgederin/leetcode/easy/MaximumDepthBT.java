package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 */
public class MaximumDepthBT {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary
     * Tree. Memory Usage: 39.6 MB, less than 84.41% of Java online submissions for Maximum Depth of
     * Binary Tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            /* compute  height of each subtree */
            int lHeight = maxDepth(root.left);
            int rHeight = maxDepth(root.right);

            /* use the larger one */
            return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
        }
    }
}
