package com.rgederin.leetcode.utils;

public class BSTUtils {

    /**
     * Insert new node with given value in BST
     *
     * @param rootNode - BST root node
     * @param val      - value for node to insert
     */
    public static void insert(TreeNode rootNode, int val) {
        TreeNode insertNode = new TreeNode(val);

        if (insertNode.val > rootNode.val) {
            if (rootNode.right != null) {
                insert(rootNode.right, val);
            } else {
                rootNode.right = insertNode;
            }
        } else {
            if (rootNode.left != null) {
                insert(rootNode.left, val);
            } else {
                rootNode.left = insertNode;
            }
        }
    }

    /**
     * Recursive search for node with given value in BST
     *
     * @param root - BST root node
     * @param val      - value for searching
     * @return - TreeNode with given value if found, null otherwise
     */
    public static TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        return val > root.val ?
                search(root.right, val) :
                search(root.left, val);
    }

    /**
     * Find minimum value in BST
     *
     * @param root - BST root node
     * @return - TreeNode with minimum value
     */
    public static TreeNode min(TreeNode root) {
        if (root.left == null) {
            return root;
        }

        return min(root.left);
    }

    /**
     * Delete minimum value from a BST:
     *  - go left until until finding the node with null left link
     *  - replace that node with it right link
     *
     * @param root - BST root node
     * @return - updated BST root node without minimum node
     */
    public static TreeNode deleteMin(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);

        return root;
    }
}
