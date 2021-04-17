package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its minimum depth. The minimum depth is the number of nodes along the
 * shortest path from the root node down to the nearest leaf node. Note: A leaf is a node with no
 * children.
 */
public class MinimumDepthBinaryTree {

    /**
     * Runtime: 4 ms, faster than 73.76% of Java online submissions for Minimum Depth of Binary
     * Tree. Memory Usage: 60 MB, less than 54.56% of Java online submissions for Minimum Depth of
     * Binary Tree.
     */
    public int minDepth(TreeNode root) {
        return minimumDepth(root);
    }

    /* Function to calculate the minimum depth of the tree */
    int minimumDepth(TreeNode root) {
        // Corner case. Should never be hit unless the code is
        // called on root = NULL
        if (root == null)
            return 0;

        // Base case : Leaf Node. This accounts for height = 1.
        if (root.left == null && root.right == null)
            return 1;

        // If left subtree is NULL, recur for right subtree
        if (root.left == null)
            return minimumDepth(root.right) + 1;

        // If right subtree is NULL, recur for left subtree
        if (root.right == null)
            return minimumDepth(root.left) + 1;

        return Math.min(minimumDepth(root.left),
                minimumDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.right = node4;

        System.out.println(new MinimumDepthBinaryTree().minDepth(root));
    }
}
