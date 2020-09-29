package com.rgederin.leetcode.medium;

import com.rgederin.leetcode.utils.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNNodeFromEndOfList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 37.1 MB, less than 98.09% of Java online submissions for Remove Nth Node From End of List.
     * Maintain two pointers and update one with a delay of n steps.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    /**
     * Runtime: 2 ms, faster than 24.56% of Java online submissions for Remove Nth Node From End of
     * List. Memory Usage: 37.1 MB, less than 98.60% of Java online submissions for Remove Nth Node
     * From End of List.
     */
    public static ListNode removeNthFromEndWithTwoPasses(ListNode head, int n) {
        int numberOfElements = 0;
        ListNode current = head;

        while (current != null) {
            numberOfElements++;
            current = current.next;
        }

        int nodeToDelete = numberOfElements - n;
        int currentNodeIndex = 0;


        if (nodeToDelete == 0) {
            head = head.next;
        }
        current = head;

        while (current != null) {
            if (currentNodeIndex == nodeToDelete - 1) {
                current.next = current.next.next;
                break;
            }
            currentNodeIndex++;
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode second = new ListNode(2);
//        ListNode third = new ListNode(3);
//        ListNode fourth = new ListNode(4);
//        ListNode fifth = new ListNode(5);

        root.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = fifth;

        removeNthFromEnd(root, 2);
    }
}
