package trees;

import java.util.*;

/**
 * 101. Symmetric Tree (easy)
 * <p>
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    /**
     * Runtime: 4 ms, faster than 7.22% of Java online submissions for Symmetric Tree.
     * Memory Usage: 38.4 MB, less than 40.75% of Java online submissions for Symmetric Tree.
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        List<Integer> level = new ArrayList<>();
        List<Integer> leftNodes, rightNodes;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {

                    level.add(null);
                    continue;
                }

                queue.add(treeNode.left);
                queue.add(treeNode.right);

                level.add(treeNode.val);
            }

            if (level.size() <= 1) {
                level.clear();
                continue;
            }
            leftNodes = level.subList(0, level.size() / 2);
            rightNodes = level.subList(level.size() / 2, level.size());
            Collections.reverse(rightNodes);

            if (!leftNodes.equals(rightNodes))
                return false;

            level.clear();
        }

        return true;
    }
}
