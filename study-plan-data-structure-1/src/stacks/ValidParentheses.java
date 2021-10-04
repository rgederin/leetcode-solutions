package stacks;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 * 20. Valid Parentheses (easy)
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 */
public class ValidParentheses {

    /**
     * Runtime: 1 ms, faster than 98.98% of Java online submissions for Valid Parentheses.
     * Memory Usage: 37 MB, less than 79.13% of Java online submissions for Valid Parentheses.
     */
    public boolean isValid(String s) {
        // Using ArrayDeque is faster than using Stack class
        Deque<Character> stack = new ArrayDeque<>();

        // Traversing the session
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }

            // IF current character is not opening
            // bracket, then it must be closing. So stack
            // cannot be empty at this point.
            if (stack.isEmpty()) {
                return false;
            }

            char pop = stack.pop();

            switch (x) {
                case ')':
                    if (pop == '{' || pop == '[')
                        return false;
                    break;

                case '}':
                    if (pop == '(' || pop == '[')
                        return false;
                    break;

                case ']':
                    if (pop == '(' || pop == '{')
                        return false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + x);
            }
        }

        // Check Empty Stack
        return stack.isEmpty();
    }
}
