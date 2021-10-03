package lists;

/**
 * 21. Merge Two Sorted Lists (easy)
 *
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Two Sorted Lists.
     * Memory Usage: 38.2 MB, less than 87.54% of Java online submissions for Merge Two Sorted Lists.
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        ListNode head = l1;

        if (l2.val < l1.val){
            head = l2;
            l2 = l2.next;
        }else {
            l1 = l1.next;
        }

        ListNode current = head;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (l1 != null){
            current.next = l1;
        }

        if(l2 != null){
            current.next = l2;
        }

        return head;
    }
}
