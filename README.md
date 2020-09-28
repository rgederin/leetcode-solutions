# Table of Content

- [Valid Parentheses](#valid-parentheses)


# Valid Parentheses

Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

```
Input: exp = “[()]{}{[()()]()}”
Output: Balanced

Input: exp = “[(])”
Output: Not Balanced
```

*Algorithm*

1. Declare a character stack S.
2. Now traverse the expression string exp.
    * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3. After complete traversal, if there is some starting bracket left in stack then “not balanced”

*Visualisation*

![valid](https://github.com/rgederin/leetcode-solutions/blob/master/img/valid.png)

