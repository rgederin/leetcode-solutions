package com.rgederin.leetcode.easy;

import com.rgederin.leetcode.utils.ListNode;

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
