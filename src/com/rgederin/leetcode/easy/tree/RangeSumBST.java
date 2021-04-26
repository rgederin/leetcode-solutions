package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. Range Sum of BST
 */
public class RangeSumBST {

    /**
     * Runtime: 6 ms, faster than 7.71% of Java online submissions for Range Sum of BST.
     * Memory Usage: 46.8 MB, less than 76.58% of Java online submissions for Range Sum of BST
     */
    public int rangeSumBST(TreeNode root, int L, int R) {
        return levelOrderBfsQueue(root, L, R);
    }

    private int levelOrderBfsQueue(TreeNode root, int L, int R) {
        int rangeSum = 0;

        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }

            if (treeNode.val >= L && treeNode.val <= R) {
                rangeSum += treeNode.val;
            }
        }
        return rangeSum;
    }

}
