package com.rgederin.leetcode.medium;

/**
 * Runtime: 11 ms, faster than 22.76% of Java online submissions for Design Linked List.
 * Memory Usage: 40.3 MB, less than 100.00% of Java online submissions for Design Linked List.
 */
class MyLinkedList {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node current = root;
        int currentIndex = 0;

        while (current != null) {
            if (currentIndex == index) {
                return current.val;
            }
            currentIndex++;
            current = current.next;
        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node node = new Node(val);
            node.next = root;
            root = node;
        }
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (root == null) {
            root = new Node(val);
        } else {
            Node current = root;

            while (current != null) {
                if (current.next == null) {
                    current.next = new Node(val);
                    return;
                }
                current = current.next;
            }
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the
     * length of linked list, the node will be appended to the end of linked list. If index is
     * greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        int currentIndex = 0;

        Node current = root;
        Node previous = null;

        if (index == 0) {
            Node node = new Node(val);
            node.next = root;
            root = node;
        } else {
            while (current != null) {
                if (currentIndex == index) {
                    Node node = new Node(val);
                    previous.next = node;
                    node.next = current;
                    return;
                }
                currentIndex++;
                previous = current;

                if (current.next == null && currentIndex == index) {
                    Node node = new Node(val);
                    current.next = node;
                    return;
                }

                current = current.next;


            }
        }

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node current = root;
        Node previous = null;
        int currentIndex = 0;

        if (index == 0) {
            root = root.next;
            return;
        }
        while (current != null) {
            if (currentIndex == index) {
                previous.next = current.next;
            }
            currentIndex++;
            previous = current;
            current = current.next;
        }

    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);

        System.out.println(linkedList);
    }
}