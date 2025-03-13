package linkedlist;

/**
 * Implement an algorithm to find the kth to last element of a singly linked list
 */
class _02_02_ReturnKthToLast {

    LinkedListNode kthToLast(LinkedListNode head, int k) {
        if (head == null || head.next == null){
            return head;
        }
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;
        for (int i =0; i< k; i++){
            if (p1.next == null){
                return null;
            }
            p1=p1.next;
        }
        while(p1.next != null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;

    }
}
