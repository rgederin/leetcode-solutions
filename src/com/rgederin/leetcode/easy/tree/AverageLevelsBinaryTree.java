package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 637. Average of Levels in Binary Tree
 */
public class AverageLevelsBinaryTree {

    /**
     * Runtime: 2 ms, faster than 72.23% of Java online submissions for Average of Levels in Binary
     * Tree. Memory Usage: 41 MB, less than 47.54% of Java online submissions for Average of Levels
     * in Binary Tree.
     */
    public List<Double> averageOfLevels(TreeNode root) {
        return levelOrderBfsQueue(root);
    }

    private List<Double> levelOrderBfsQueue(TreeNode root) {
        List<Double> averages = new ArrayList<>();

        if (root == null) {
            return averages;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            double average = 0;

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                average += treeNode.val;
            }
            averages.add(average / size);
        }

        return averages;
    }
}
