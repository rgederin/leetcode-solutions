package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. Find Largest Value in Each Tree Row
 */
public class LargestValueEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        return levelOrderBfsQueue(root);
    }

    /**
     * Runtime: 1 ms, faster than 89.06% of Java online submissions for Find Largest Value in Each
     * Tree Row. Memory Usage: 39.3 MB, less than 29.42% of Java online submissions for Find Largest
     * Value in Each Tree Row.
     */
    private List<Integer> levelOrderBfsQueue(TreeNode root) {
        List<Integer> largest = new ArrayList<>();

        if (root == null) {
            return largest;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            int levelLargest = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

                if (treeNode.val > levelLargest) {
                    levelLargest = treeNode.val;
                }
            }
            largest.add(levelLargest);
        }

        return largest;
    }
}
