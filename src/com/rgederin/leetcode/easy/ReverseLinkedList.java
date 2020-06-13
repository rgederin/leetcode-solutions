package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.ListNode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 40.3 MB, less than 8.07% of Java online submissions for Reverse Linked List.
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode (3);
        ListNode fourth = new ListNode(4);

        root.next = second;
        second.next = third;
        third.next = fourth;

        reverseList(root);
    }

    private static void printLinkedList (ListNode root){
        ListNode current = root;

        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
