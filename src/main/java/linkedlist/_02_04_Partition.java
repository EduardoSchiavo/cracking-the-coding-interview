package linkedlist;

/**
 * Partition: Write code to partition a linked list around a value x,
 * such that all nodes less than x come before all nodes greater than or equal to x.
 * If x is contained within the list, the values of x only need to be after the elements less than x (see below).
 * The partition element x can appear anywhere in the "right partition";
 * it does not need to appear between the left and right partitions.
 * EXAMPLE
 * Input: 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1[partition=5]
 * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
 */
class _02_04_Partition {

    LinkedListNode partition(LinkedListNode head, int x) {
        if (head == null || head.next == null){
            return head;
        }
        LinkedListNode curr = head;
        LinkedListNode lH;
        LinkedListNode lT;
        LinkedListNode rH;
        LinkedListNode rT;
        lH = lT = null;
        rH = rT = null;

        while (curr != null){
            System.out.println("curr: " +  curr.val);
            if (curr.val < x){
                if (lH == null){
                    lH = lT = curr;
                } else {
                    lT.next = curr;
                    lT = curr;
                }
            } else {
                if (rH == null){
                    rH = rT = curr;
                } else {
                    rT.next = curr;
                    rT = curr;
                }
            }
            curr = curr.next;
        }

        rT.next = null;
        if (lT != null){
            lT.next = rH;
            return lH;
        }

        return rH;
    }


}
