package com.rgederin.leetcode.datastuctures;

/**
 * Binary Search Tree datastructure
 */
public class BinarySearchTree<T> {
    private TreeNode<T> root;

    public BinarySearchTree(Integer key, T value) {
        root = new TreeNode<>(key, value);
    }

    public BinarySearchTree(Integer key) {
        root = new TreeNode<>(key, null);
    }

    public void insert(Integer key, T value) {
        insertRecursive(root, key, value);
    }

    public void insert(Integer key, T value, boolean isRecursive) {
        if (isRecursive) {
            insertRecursive(root, key, value);
        } else {
            insertIterative(key, value);
        }
    }

    public void insert(Integer key) {
        insertRecursive(root, key, null);
    }

    public void insert(Integer key, boolean isRecursive) {
        if (isRecursive) {
            insertRecursive(root, key, null);
        } else {
            insertIterative(key, null);
        }
    }

    public T search(Integer key) {
        TreeNode<T> searchResult = searchRecursive(root, key);

        return searchResult == null ? null : searchResult.value;
    }

    public T search(Integer key, boolean isRecursive) {
        TreeNode<T> searchResult = isRecursive ? searchRecursive(root, key) : searchIteratively(key);

        return searchResult == null ? null : searchResult.value;
    }

    /**
     * Iteratively insert node in BST
     */
    private void insertIterative(Integer key, T value) {
        TreeNode<T> node = root;
        TreeNode<T> insertNode = new TreeNode<>(key, value);

        while (node != null) {
            if (key > node.key) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = insertNode;
                    return;
                }
            } else if (key < node.key) {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = insertNode;
                    return;
                }
            } else {
                node.value = value;
                return;
            }
        }
    }

    /**
     * Recusively insert node in BST
     */
    private void insertRecursive(TreeNode<T> root, Integer key, T value) {
        if (key > root.key) {
            if (root.right != null) {
                insertRecursive(root.right, key, value);
            } else {
                root.right = new TreeNode<>(key, value);
            }
        } else if (key < root.key) {
            if (root.left != null) {
                insertRecursive(root.left, key, value);
            } else {
                root.left = new TreeNode<>(key, value);
            }
        } else {
            root.value = value;
        }
    }

    /**
     * Iterativaly search node in BST
     */
    private TreeNode<T> searchIteratively(int key) {
        TreeNode<T> node = root;

        while (node != null) {
            if (key == node.key) {
                return node;
            }

            if (key < node.key) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        return null;
    }

    /**
     * Recursively search node in BST
     */
    public TreeNode<T> searchRecursive(TreeNode<T> node, int key) {
        if (node == null || node.key == key) {
            return node;
        }

        return key > node.key ?
                searchRecursive(node.right, key) :
                searchRecursive(node.left, key);
    }



    private static class TreeNode<T> {
        private final Integer key;
        private T value;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(Integer key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

class Driver {
    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>(5, "Karpov");

        tree.insert(3, "Ruslan");
        tree.insert(4, "Arina");
        tree.insert(9, "Anna");
        tree.insert(4, "Dima");
        tree.insert(6, "Misha", false);

        System.out.println(tree.search(8, false));
        //Collections.sort();

    }
}