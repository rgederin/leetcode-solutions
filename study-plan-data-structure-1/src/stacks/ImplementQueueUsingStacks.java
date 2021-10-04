package stacks;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks (easy)
 * <p>
 * Implement a first in first out (FIFO) queue using only two stacks.
 * The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty)
 */
public class ImplementQueueUsingStacks {

    private Stack<Integer> main;
    private Stack<Integer> operational;

    /**
     * Runtime: 1 ms, faster than 19.95% of Java online submissions for Implement Queue using Stacks.
     * Memory Usage: 38.4 MB, less than 25.42% of Java online submissions for Implement Queue using Stacks.
     */
    public ImplementQueueUsingStacks() {
        main = new Stack<>();
        operational = new Stack<>();
    }

    public void push(int x) {
        int mainSize = main.size();

        for (int i = 0; i < mainSize; i++) {
            operational.add(main.pop());
        }

        operational.push(x);

        int operationalSize = operational.size();
        for (int i = 0; i < operationalSize; i++) {
            main.push(operational.pop());
        }
    }

    public int pop() {
        return main.pop();
    }

    public int peek() {
        return main.peek();
    }

    public boolean empty() {
        return main.isEmpty();
    }
}

