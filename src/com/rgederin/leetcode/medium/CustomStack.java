package com.rgederin.leetcode.medium;

/**
 * Runtime: 5 ms, faster than 93.19% of Java online submissions for Design a Stack With Increment
 * Operation. Memory Usage: 40.2 MB, less than 100.00% of Java online submissions for Design a Stack
 * With Increment Operation.
 */
class CustomStack {
    private int maxSize;
    private int numOfElements;
    private int[] stack;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    /**
     * Adds x to the top of the stack if the stack hasn't reached the maxSize
     */
    public void push(int x) {
        if (!isFull()) {
            stack[numOfElements++] = x;
        }
    }

    /**
     * Pops and returns the top of stack or -1 if the stack is empty.
     */
    public int pop() {
        if (!isEmpty()) {
            return stack[--numOfElements];
        }
        return -1;
    }

    /**
     * Increments the bottom k elements of the stack by val. If there are less than k elements in
     * the stack, just increment all the elements in the stack.
     */
    public void increment(int k, int val) {
        // if (k>)
        if (k > maxSize) {
            k = maxSize;
        }
        for (int i = 0; i < k; i++) {
            stack[i] += val;
        }
    }

    private boolean isEmpty() {
        return numOfElements == 0;
    }

    private boolean isFull() {
        return numOfElements == maxSize;
    }

    public static void main(String[] args) {
        CustomStack stack = new CustomStack(3);

        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.increment(5, 100);
        stack.increment(2, 100);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}