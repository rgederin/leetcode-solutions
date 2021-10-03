package lists;

/**
 * 203. Remove Linked List Elements (easy)
 * Given the head of a linked list and an integer val,
 * remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
public class RemoveLinkedListElements {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 39.6 MB, less than 92.73% of Java online submissions for Remove Linked List Elements.
     */
    public ListNode removeElements(ListNode head, int val) {
        // Corner case #1 - null passed to the function
        if (null == head)
            return null;

        // Corner case #2 - only one element in the list passed to the function
        if (null == head.next) {
            if (head.val == val)
                return null;
            return head;
        }

        // Corner case #3 - handle case when first elements needs to be deleted
        while (head != null && head.val == val)
            head = head.next;

        ListNode currentNode = head;

        while (currentNode != null) {
            if (currentNode.next != null && currentNode.next.val == val)
                currentNode.next = currentNode.next.next;
            else
                currentNode = currentNode.next;

        }

        return head;
    }
}
