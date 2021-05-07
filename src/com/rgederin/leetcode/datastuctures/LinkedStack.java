package com.rgederin.leetcode.datastuctures;

public class LinkedStack<T> {

    private Node<T> first;
    private int size;

    /**
     * Insert element in the head of internal linked list
     *
     * @param item - item to push
     */
    public void push(T item) {
        Node<T> oldfirst = first;
        first = new Node<>();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    /**
     * Remove element from the head of internal linked list and return it
     *
     * @return T - the most recently added element in stack (LIFO)
     */
    public T pop() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("stack is empty");
        }

        T item = first.item;
        first = first.next;
        size--;

        return item;
    }

    /**
     * Is empty
     *
     * @return true if is empty, false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Current size of the stack
     *
     * @return size of the stack
     */
    public int size() {
        return size;
    }

    private class Node<T> {
        T item;
        Node<T> next;
    }

}
