package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.ListNode;

import java.util.Stack;

/**
 * 234. Palindrome Linked List
 *
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class PalindromeLinkedList {

    /**
     * Runtime: 10 ms, faster than 15.83% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 51.2 MB, less than 21.17% of Java online submissions for Palindrome Linked
     * List.
     *
     */
    public static boolean isPalindrome(ListNode head) {
        if (head.next == null) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        System.out.println("prepared stack: " + stack);

        current = head;

        System.out.println("Current: " + current);

        while (current != null) {
            if (stack.pop() != current.val) {
                return false;
            }
            current = current.next;
        }

        return true;
    }

    public static void main(String[] args) {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;

        System.out.println(isPalindrome(n0));
    }
}
