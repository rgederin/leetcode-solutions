package lists;

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
