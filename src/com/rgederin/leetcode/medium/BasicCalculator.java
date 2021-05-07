package com.rgederin.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        // Stack for numbers: 'values'
        Stack<Integer> values = new Stack<>();

        // Stack for Operators: 'ops'
        Stack<String> operators = new Stack<>();


        for (String string : parse(s)) {
            if (!isOperator(string)) {
                values.push(Integer.valueOf(string));
            }

            else if (string.equals('(')) {
                operators.push(string);
            }

            else if (string.equals(')')){
                while (operators.peek() != "("){
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }
            }

            else if (isOperator(string)){
                while (!operators.empty() && hasPrecedence(string, operators.peek())){
                    values.push(applyOp(operators.pop(), values.pop(), values.pop()));
                }

                operators.push(string);
            }
        }

        while (!operators.isEmpty()){
            values.push(applyOp(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    // Returns true if 'op2' has higher
    // or same precedence as 'op1',
    // otherwise returns false.
    public static boolean hasPrecedence(String op1, String op2) {
        if ((op1.equals("*") || op1.equals("/")) &&
                (op2.equals("+") || op2.equals("-")))
            return false;
        else
            return true;
    }

    // A utility method to apply an
    // operator 'op' on operands 'a'
    // and 'b'. Return the result.
    public int applyOp(String op, int b, int a) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Cannot divide by zero");
                return a / b;
        }
        return 0;
    }

    private List<String> parse(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder element = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (isOperator(ch)) {
                if (!element.equals("")) {
                    result.add(String.valueOf(element).trim());
                    element = new StringBuilder();
                }
                result.add(String.valueOf(ch));
            } else {
                element.append(ch);

            }
        }
        result.add(String.valueOf(element).trim());

        return result;
    }

    private boolean isOperator(char ch) {
        return ch == '-' || ch == '+' || ch == '*' || ch == '/';
    }

    private boolean isOperator(String s) {
        boolean result = s.equals("-") || s.equals("+") || s.equals("*") || s.equals("/");
        return result;
    }

    public static void main(String[] args) {
        String test = " 3/2 ";
        System.out.println(new BasicCalculator().calculate(test));
    }
}
