package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 226. Invert Binary Tree
 */
public class InvertBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree. Memory
     * Usage: 36.3 MB, less than 73.32% of Java online submissions for Invert Binary Tree.
     */
    public TreeNode invertTree(TreeNode root) {
        bfsWithInversion(root);

        return root;
    }

    private void bfsWithInversion(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            //remove node from queue
            TreeNode treeNode = queue.poll();

            if (treeNode == null) {
                return;
            }

            swapChildren(treeNode);

            /*Enqueue left child */
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }

            /*Enqueue right child */
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
    }

    private void swapChildren(TreeNode treeNode) {
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;
    }
}
