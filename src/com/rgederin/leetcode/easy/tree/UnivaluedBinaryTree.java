package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 965. Univalued Binary Tree
 */
public class UnivaluedBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Univalued Binary Tree.
     * Memory Usage: 36.5 MB, less than 37.73% of Java online submissions for Univalued Binary
     * Tree.
     *
     * @param root
     * @return
     */
    public boolean isUnivalTree(TreeNode root) {
        return levelOrderBfsQueue(root);
    }

    private boolean levelOrderBfsQueue(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();

            if (root.val != treeNode.val) {
                return false;
            }
            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return true;
    }
}
