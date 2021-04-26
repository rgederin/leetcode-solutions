package com.rgederin.leetcode.easy.tree;

import com.rgederin.leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return levelOrderBfsQueue(p, q);
    }

    private boolean levelOrderBfsQueue(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();

        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pTreeNode = pQueue.poll();
            TreeNode qTreeNode = qQueue.poll();

            if (!isSameNode(pTreeNode, qTreeNode)) {
                return false;
            }

            if (pTreeNode.left != null) {
                pQueue.add(pTreeNode.left);
            }
            if (pTreeNode.right != null) {
                pQueue.add(pTreeNode.right);
            }

            if (qTreeNode.left != null) {
                qQueue.add(qTreeNode.left);
            }
            if (qTreeNode.right != null) {
                qQueue.add(qTreeNode.right);
            }
        }
        return true;
    }

    private boolean isSameNode(TreeNode p, TreeNode q) {
        // p and q are null
        if (p == null && q == null) {
            return true;
        }
        // one of p and q is null
        if (q == null || p == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return true;
    }
}
