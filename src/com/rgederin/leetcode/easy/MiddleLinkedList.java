package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.ListNode;

/**
 * 876. Middle of the Linked List
 * <p>
 * Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 */
public class MiddleLinkedList {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
     * Memory Usage: 36.4 MB, less than 38.88% of Java online submissions for Middle of the Linked
     * List.
     */
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        boolean move = false;

        while (first != null) {
            first = first.next;

            if (move) {
                second = second.next;
                move = false;
            } else {
                move = true;
            }
        }

        return second;
    }
    
    public ListNode referenceMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
