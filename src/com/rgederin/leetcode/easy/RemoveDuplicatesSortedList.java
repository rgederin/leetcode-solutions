package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.ListNode;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
 * Memory Usage: 38.7 MB, less than 97.63% of Java online submissions for Remove Duplicates from Sorted List.
 */
public class RemoveDuplicatesSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.next != null && currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            } else{
                currentNode = currentNode.next;
            }
        }

        return head;
    }
}
