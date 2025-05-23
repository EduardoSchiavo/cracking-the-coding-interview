package linkedlist;

/**
 * Sum Lists: You have two numbers represented by a linked list,
 * where each node contains a single digit.
 * The digits are stored in normal order, such that the 1 's digit is at the tail of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 * <p>
 * EXAMPLE
 * Input:(7-> 1 -> 6) + (5 -> 9 -> 2).That is, 716 + 592.
 * Output:1 -> 4 -> 0 -> 8.That is, 1408.
 */
class _02_05_SumList {

    LinkedListNode sum(LinkedListNode l1, LinkedListNode l2) {
        System.out.println("before l1, l2 " + l1 + l2);
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        System.out.println("after l1, l2 " + l1 + l2);

        if (l1 == null && l2 == null){
            return null;
        }

        LinkedListNode resH = null;
        LinkedListNode resT = null;
        LinkedListNode c1 = l1;
        LinkedListNode c2 = l2;
        int[] resAndCarry = new int[]{0, 0};

        while ( c1 != null || c2 != null){
            int n1 = (c1 != null) ? c1.val : 0;
            int n2 = (c2 != null) ? c2.val : 0;
            resAndCarry = addNumbers(n1,n2, resAndCarry[1]);
            if (resH == null){
                resH = new LinkedListNode(resAndCarry[0]);
                resT = resH;
            } else {
                resT.next = new LinkedListNode(resAndCarry[0]);
                resT = resT.next;
            }
            c1 = (c1 != null) ? c1.next : null;
            c2 = (c2 != null) ? c2.next : null;
        }
        if (resAndCarry[1] == 1){
            resT.next = new LinkedListNode(1);
        }

        return reverseList(resH);
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
        head = curr;
        return head;
    }
    private int[] addNumbers(int a, int b, int r){
        int res = a + b + r;
        int carry = (res>9) ? 1 : 0;
        return new int[]{res%10, carry};
    }

    }




