package trees;

/**
 * 104. Maximum Depth of Binary Tree (easy)
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaxDepthBinaryTree {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 38.9 MB, less than 61.97% of Java online submissions for Maximum Depth of Binary Tree.
     */
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        else {
            /* compute  height of each subtree */
            int lheight = maxDepth(root.left);
            int rheight = maxDepth(root.right);

            /* use the larger one */
            return lheight > rheight ? lheight + 1 : rheight + 1;
        }
    }
}
