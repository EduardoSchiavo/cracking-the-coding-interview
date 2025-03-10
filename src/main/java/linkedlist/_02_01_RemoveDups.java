package linkedlist;


import java.util.HashMap;
import java.util.Map;

/**
 * Remove Dups!
 * Write code to remove duplicates from an unsorted linked list.
 */
class _02_01_RemoveDups {

    LinkedListNode removeDups(LinkedListNode head) {
        if (head == null){
            return null;
        }
        LinkedListNode curr = head;
        Map<Integer, Integer> duplicates = getDuplicatesMap(head);
        while (curr.next != null){
           if (duplicates.get(curr.next.val)>1){
               removeNextNode(curr);
           }
           curr = curr.next;
        }
        return head;

    }

    private Map<Integer, Integer> getDuplicatesMap(LinkedListNode head) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        LinkedListNode curr = head;
        while (curr != null) {
            if (!occurrences.containsKey(curr.val)) {
                occurrences.put(curr.val, 0);
            }
            occurrences.put(curr.val, occurrences.get(curr.val) + 1);
            curr = curr.next;
        }
        return occurrences;
    }

    private void removeNextNode(LinkedListNode n){
        LinkedListNode tmpNode = n.next.next;
        n.next.next = null;
        n.next = tmpNode;
    }
}
