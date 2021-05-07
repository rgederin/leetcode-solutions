package com.rgederin.leetcode.medium.stack;

import java.util.Stack;


public class BasicCalculator {

    /**
     * Runtime: 15 ms, faster than 20.81% of Java online submissions for Basic Calculator II. Memory
     * Usage: 40.7 MB, less than 21.52% of Java online submissions for Basic Calculator II.
     */
    public int calculate(String s) {
        //split char array to individual tokens
        char[] tokens = s.toCharArray();

        // stack for numbers
        Stack<Integer> values = new Stack<>();

        // stack for operators: 'ops'
        Stack<Character> operators = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            //if current token is whitespace, skip it
            if (tokens[i] == ' ') {
                continue;
            }

            //if current token is digit - push it to the value stack
            else if (isDigit(tokens[i])) {
                StringBuffer sbuf = new StringBuffer();

                // There may be more than one digits in number
                while (i < tokens.length && isDigit(tokens[i])) {
                    sbuf.append(tokens[i++]);
                }

                values.push(Integer.parseInt(sbuf.toString()));

                //normalise iteration
                i--;
            }

            // Current token is an operator.
            else if (isOperator(tokens[i])) {
                // While top of 'ops' has same or greater precedence to current token, which is an operator.
                // Apply operator on top of 'ops' to top two elements in values stack
                while (!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
                    values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
                }

                // Push current token to 'ops'.
                operators.push(tokens[i]);
            }
        }

        // Entire expression has been parsed at this point, apply remaining ops to remaining values
        while (!operators.empty()) {
            values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
        }

        // Top of 'values' contains result, return it
        return values.pop();
    }

    private boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }


    // Returns true if 'op2' has higher or same precedence as 'op1',otherwise returns false.
    public static boolean hasPrecedence(char op1, char op2) {

        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-')) {
            return false;
        } else {
            return true;
        }
    }

    public int applyOperation(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }

    private boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }

    public static void main(String[] args) {
        String test = " 3/2 ";
        System.out.println(new BasicCalculator().calculate(test));
    }
}
