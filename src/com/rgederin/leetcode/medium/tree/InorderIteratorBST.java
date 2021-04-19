package com.rgederin.leetcode.medium.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

import static com.rgederin.leetcode.utils.BSTUtils.insert;
import static com.rgederin.leetcode.utils.DFSUtils.inorderDFS;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the
 * root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height
 * of the tree. You may assume that next() call will always be valid, that is, there will be at
 * least a next smallest number in the BST when next() is called.
 */
public class InorderIteratorBST {

    /**
     * Runtime: 14 ms, faster than 99.88% of Java online submissions for BST Iterator.
     * Memory Usage: 44.5 MB, less than 100.00% of Java online submissions for BST Iterator.
     */
    private final List<TreeNode> inorderIteratorList;
    private int index;

    public InorderIteratorBST(TreeNode root) {
        inorderIteratorList = new ArrayList<>();

        //Run inorder depth first search and fill list in non-decrising order
        inorderDFS(root, inorderIteratorList::add);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int next = inorderIteratorList.get(index).val;
        index++;

        return next;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return index < inorderIteratorList.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        insert(root, 3);
        insert(root, 6);
        insert(root, 2);
        insert(root, 4);
        insert(root, 7);

        List<TreeNode> inorderList = new ArrayList<>();

        inorderDFS(root, inorderList::add);
        inorderList.forEach(System.out::println);
    }
}
