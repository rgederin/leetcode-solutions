package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 1161. Maximum Level Sum of a Binary Tree
 */
public class MaximumLevelSumBinaryTree {

    /**
     * Runtime: 12 ms, faster than 11.22% of Java online submissions for Maximum Level Sum of a
     * Binary Tree. Memory Usage: 72.9 MB, less than 5.09% of Java online submissions for Maximum
     * Level Sum of a Binary Tree.
     *
     */
    public int maxLevelSum(TreeNode root) {

        List<Integer> levelsSum = levelOrderBfsQueue(root);

        int largestIndex = -1;
        int largestSum = Integer.MIN_VALUE;

        for (int i = 1; i <= levelsSum.size(); i++) {
            if (levelsSum.get(i - 1) > largestSum) {
                largestSum = levelsSum.get(i - 1);
                largestIndex = i;
            }
        }
        return largestIndex;
    }

    private List<Integer> levelOrderBfsQueue(TreeNode root) {
        List<Integer> levelsSum = new ArrayList<>();

        if (root == null) {
            return levelsSum;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelSum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                levelSum += treeNode.val;
            }
            levelsSum.add(levelSum);
        }

        return levelsSum;
    }
}


