package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1302. Deepest Leaves Sum
 */
public class DeepestLeavesSum {


    /**
     * Runtime: 5 ms, faster than 10.91% of Java online submissions for Deepest Leaves Sum.
     * Memory Usage: 49.7 MB, less than 10.13% of Java online submissions for Deepest Leaves Sum.
     * @param root
     * @return
     */
    public int deepestLeavesSum(TreeNode root) {
        return levelOrderBfsQueue(root);
    }

    private int levelOrderBfsQueue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

       // List<Integer> levelList = null;
        int levelSum = 0;
        while (!queue.isEmpty()) {
            levelSum = 0;
           // levelList = new ArrayList<>();
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

               // levelList.add(treeNode.val);
                levelSum += treeNode.val;
            }
        }
        return levelSum;
    }
}
