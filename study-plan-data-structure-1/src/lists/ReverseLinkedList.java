package lists;

/**
 * 206. Reverse Linked List (easy)
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
     * Memory Usage: 39.9 MB, less than 13.36% of Java online submissions for Reverse Linked List.
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null){
            // save current next point in temp var
            next = curr.next;

            // reverse next pointer to previous
            curr.next = prev;

            // reassign pointers
            prev = curr;
            curr = next;
        }

        // new head at the end
        return prev;
    }
}
