package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e.,
 * from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrderBfsQueue(root);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order
     * Traversal. Memory Usage: 39.2 MB, less than 54.22% of Java online submissions for Binary Tree
     * Level Order Traversal.
     */
    private List<List<Integer>> levelOrderBfsQueue(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                levelList.add(treeNode.val);
            }
            levels.add(levelList);
        }
        return levels;
    }

    /**
     * Runtime: 3 ms, faster than 6.67% of Java online submissions for Binary Tree Level Order
     * Traversal. Memory Usage: 39.1 MB, less than 69.24% of Java online submissions for Binary Tree
     * Level Order Traversal
     */
    private List<List<Integer>> levelOrderBfsRecursion(TreeNode root) {
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
    private int height(TreeNode root) {
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

    /**
     * Visit nodes at the given level
     */
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
