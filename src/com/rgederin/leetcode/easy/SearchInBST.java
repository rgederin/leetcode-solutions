package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.BSTUtils;
import com.rgederin.leetcode.utils.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value. You need to find the node in the
 * BST that the node's value equals the given value. Return the subtree rooted with that node. If
 * such node doesn't exist, you should return NULL.
 */
public class SearchInBST {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search
     * Tree. Memory Usage: 39.8 MB, less than 68.89% of Java online submissions for Search in a
     * Binary Search Tree.
     */
    public TreeNode searchBST(TreeNode root, int val) {
        return BSTUtils.search(root, val);
    }
}
