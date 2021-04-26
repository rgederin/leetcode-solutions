package com.rgederin.leetcode.easy.linkedlist;

import com.rgederin.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * <p>
 * Given head which is a reference node to a singly-linked list. The value of each node in the
 * linked list is either 0 or 1. The linked list holds the binary representation of a number.
 * <p>
 * Return the decimal value of the number in the linked list.
 */
public class BinaryNumberInLinkedList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a
     * Linked List to Integer. Memory Usage: 36 MB, less than 99.16% of Java online submissions for
     * Convert Binary Number in a Linked List to Integer.
     *
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        List<Integer> binary = new ArrayList<>();

        while (head != null) {
            binary.add(head.val);
            head = head.next;
        }

        System.out.println(binary);

        int decimal = 0;

        for (int i = binary.size() - 1, j = 0; i >= 0; i--, j++) {
            if (binary.get(i) == 1) {
                decimal += Math.pow(2, j);
            }
        }

        return decimal;
    }

    public static void main(String[] args) {
        //[1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(0);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(0);
        ListNode l6 = new ListNode(0);
        ListNode l7 = new ListNode(1);
        ListNode l8 = new ListNode(1);
        ListNode l9 = new ListNode(1);
        ListNode l10 = new ListNode(0);
        ListNode l11 = new ListNode(0);
        ListNode l12 = new ListNode(0);
        ListNode l13 = new ListNode(0);
        ListNode l14 = new ListNode(0);
        ListNode l15 = new ListNode(0);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l15;

        System.out.println(getDecimalValue(l1));
    }
}
