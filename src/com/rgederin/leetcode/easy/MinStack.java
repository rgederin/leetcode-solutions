package com.rgederin.leetcode.easy;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Runtime: 129 ms, faster than 7.78% of Java online submissions for Min Stack.
 * Memory Usage: 41.2 MB, less than 14.50% of Java online submissions for Min Stack.
 */
class MinStack {

    private Node top;

    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x);
        } else {
            Node node = new Node(x);
            node.next = top;
            top = node;
        }
    }

    public void pop() {
        top = top.next;
    }

    public int top() {
        return top.val;
    }

    public int getMin() {
        int min = top.val;
        Node current = top;
        while (current != null) {
            if (current.val < min) {
                min = current.val;
            }
            current = current.next;
        }

        return min;
    }

    private class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        //["MinStack","push","push","push","getMin","pop","top","getMin"]
        //[[],[-2],[0],[-3],[],[],[],[]]

        MinStack stack = new MinStack();

        stack.push(-2);
        stack.push(0);
        stack.push(-3);
        System.out.println(stack.getMin());
        stack.pop();
        stack.top();
        System.out.println(stack.getMin());
    }
}