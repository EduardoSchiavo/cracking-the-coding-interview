package linkedlist;

/**
 * Palindrome: Implement a function to check if a linked list is a palindrome.
 */
class _02_06_Palindrome {

    boolean isPalindrome(LinkedListNode head) {
        LinkedListNode previous = deepCopyList(head);
        LinkedListNode rev = reverseList(head);
        return areEqual(previous, rev);

    }

    private LinkedListNode deepCopyList(LinkedListNode head){
        if (head == null){ return null;}

        LinkedListNode newHead = new LinkedListNode(head.val);
        LinkedListNode curr = head;
        LinkedListNode newCurr = newHead;
        while(curr.next != null){
            newCurr.next = new LinkedListNode(curr.next.val);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        return newHead;
    }

    private LinkedListNode reverseList(LinkedListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        LinkedListNode curr = head;
        LinkedListNode prev = null;

        while (curr.next != null) {
            LinkedListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        curr.next = prev;

        return curr;
    }


    private boolean areEqual(LinkedListNode a, LinkedListNode b) {
        while (a != null && b != null) {
            if (a.val != b.val) return false;
            a = a.next;
            b = b.next;
        }
        return a == null && b == null;
    }
}
