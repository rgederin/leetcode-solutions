package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 */
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        insertIterative(root, val);
        return root;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search
     * Tree. Memory Usage: 39.7 MB, less than 34.73% of Java online submissions for Insert into a
     * Binary Search Tree.
     */
    private void insertRecursion(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);

        if (insertNode.val > root.val) {
            if (root.right != null) {
                insertRecursion(root.right, val);
            } else {
                root.right = insertNode;
            }
        } else {
            if (root.left != null) {
                insertRecursion(root.left, val);
            } else {
                root.left = insertNode;
            }
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search
     * Tree. Memory Usage: 39.3 MB, less than 88.59% of Java online submissions for Insert into a
     * Binary Search Tree.
     */
    private void insertIterative(TreeNode root, int val) {
        TreeNode insertNode = new TreeNode(val);

        TreeNode node = root;
        while (node != null) {
            if (val > node.val) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = insertNode;
                    return;
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = insertNode;
                    return;
                }
            }
        }
    }
}
