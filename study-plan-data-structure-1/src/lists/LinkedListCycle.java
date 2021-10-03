package lists;

import java.util.HashSet;
import java.util.Set;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 * <p>
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {

    /**
     * Runtime: 4 ms, faster than 19.93% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.4 MB, less than 96.01% of Java online submissions for Linked List Cycle.
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();

        while (head != null) {
            if (visited.contains(head))
                return true;
            visited.add(head);
            head = head.next;
        }

        return false;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.8 MB, less than 81.10% of Java online submissions for Linked List Cycle.
     */
    public boolean twoPointers(ListNode head) {
        if (head == null)
            return false;

        //Fast is one step ahead of slow
        ListNode slow = head;
        ListNode fast = head.next;

        //Fast and slow would only be at same position
        //if there is a loop
        //else fast would reach to end i.e null before slow
        while (fast != slow) {
            if (fast == null || fast.next == null) //order needs to be same
                return false;                //don't interchange
            //else null pointer exception (Think!?)
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}