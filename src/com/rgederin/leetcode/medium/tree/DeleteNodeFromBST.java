package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import static com.rgederin.leetcode.utils.BSTUtils.deleteMin;
import static com.rgederin.leetcode.utils.BSTUtils.insert;
import static com.rgederin.leetcode.utils.BSTUtils.min;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 * <p>
 * Basically, the deletion can be divided into two stages:
 * <p>
 * Search for a node to remove. If the node is found, delete the node.
 * <p>
 * Note: Time complexity should be O(height of tree).
 * <p>
 */
public class DeleteNodeFromBST {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a BST.
     * Memory Usage: 39.9 MB, less than 20.69% of Java online submissions for Delete Node in a BST.
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        return hibbardDeletion(root, key);
    }

    /**
     * Delete node from BST solution ussing Hibbard deletion method:
     *
     * To delete node with key k
     *
     * 1. Search for node t containing key k
     *
     * 2.1. Case 0 [0 children] - Delete node t by setting parent link to null
     * 2.2. Case 1 [1 child] - Delete node t by replacing parent link to its child
     * 2.3. Case 2 [2 children] -
     *      2.3.1. Find in-order successor x of node to delete t (minimum key in right subtree of the node to delete t)
     *      2.3.2. Delete the minimum in the right subtree of the t
     *      2.3.3. Put x in t place
     *
     * @param root BST root node
     * @param key key to delete
     * @return - updated BST root node without minimum node
     */
    private static TreeNode hibbardDeletion(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        if (key > root.val) {
            root.right = hibbardDeletion(root.right, key);
        } else if (key < root.val) {
            root.left = hibbardDeletion(root.left, key);
        } else {

            // Cases with 0 and 1 child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // two children case
            TreeNode temp = root;

            root = min(temp.right);
            root.right = deleteMin(temp.right);
            root.left = temp.left;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        insert(root, 3);
        insert(root, 6);
        insert(root, 2);
        insert(root, 4);
        insert(root, 7);
        
        TreeNode min = min(root);
        root = hibbardDeletion(root, 5);

        System.out.println(root);
    }
}


