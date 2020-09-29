# Table of Content

- [Valid Parentheses](#valid-parentheses)
- [Remove Nth Node From End of List](#remove-nth-node-from-end-of-list)



## Valid Parentheses

Given an expression string exp, write a program to examine whether the pairs and the orders of “{“, “}”, “(“, “)”, “[“, “]” are correct in exp.

```
Input: exp = “[()]{}{[()()]()}”
Output: Balanced

Input: exp = “[(])”
Output: Not Balanced
```

**Algorithm**

1. Declare a character stack S.
2. Now traverse the expression string exp.
    * If the current character is a starting bracket (‘(‘ or ‘{‘ or ‘[‘) then push it to stack.
    * If the current character is a closing bracket (‘)’ or ‘}’ or ‘]’) then pop from stack and if the popped character is the matching starting bracket then fine else parenthesis are not balanced.
3. After complete traversal, if there is some starting bracket left in stack then “not balanced”

**Visualisation**

![valid](https://github.com/rgederin/leetcode-solutions/blob/master/img/valid.png)


## Remove Nth Node From End of List

Given a linked list, remove the n-th node from the end of list and return its head. Given n will always be valid.

**Example**
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```

**Approach 1: Two pass algorithm**

We notice that the problem could be simply reduced to another one : Remove the (L - n + 1)th node from the beginning in the list , where LL is the list length. This problem is easy to solve once we found list length LL.

First we will add an auxiliary "dummy" node, which points to the list head. The "dummy" node is used to simplify some corner cases such as a list with only one node, or removing the head of the list. On the first pass, we find the list length LL. Then we set a pointer to the dummy node and start to move it through the list till it comes to the (L - n)(L−n) th node. We relink next pointer of the (L - n)(L−n) th node to the (L - n + 2)(L−n+2) th node and we are done.

![rm_node_1](https://github.com/rgederin/leetcode-solutions/blob/master/img/rm_node_1.png)


**Approach 2: One pass algorithm**

The above algorithm could be optimized to one pass. Instead of one pointer, we could use two pointers. The first pointer advances the list by n+1n+1 steps from the beginning, while the second pointer starts from the beginning of the list. Now, both pointers are exactly separated by nn nodes apart. We maintain this constant gap by advancing both pointers together until the first pointer arrives past the last node. The second pointer will be pointing at the nnth node counting from the last. We relink the next pointer of the node referenced by the second pointer to point to the node's next next node

![rm_node_2](https://github.com/rgederin/leetcode-solutions/blob/master/img/rm_node2.png)

