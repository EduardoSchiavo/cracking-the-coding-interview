package linkedlist;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class _02_04_PartitionTest {

    private _02_04_Partition s = new _02_04_Partition();

    @Test
    public void withEmptyList() {
        assertEquals(LinkedListNode.empty(), s.partition(LinkedListNode.empty(), 8));
    }

    @Test
    public void withSortedList() {
        assertPartition(LinkedListNode.of(1, 2, 3), s.partition(LinkedListNode.of(1, 2, 3), 2), 2);
    }

    @Test
    public void withSortedList_AndOutOfListX() {
        assertPartition(LinkedListNode.of(3, 2, 1), s.partition(LinkedListNode.of(1, 2, 3), 4), 4);
    }

    @Test
    public void withSortedList_AndOutOfListX_Smaller() {
        assertPartition(LinkedListNode.of(1, 2, 3), s.partition(LinkedListNode.of(1, 2, 3), 0), 0);
    }

    @Test
    public void withUnSortedList() {
        assertPartition(LinkedListNode.of(1, 2, 4, 3, 5), s.partition(LinkedListNode.of(4, 3, 2, 5, 1), 3), 3);
    }

    @Test
    public void withUnSortedList_AndOutOfScopeX() {
        assertPartition(LinkedListNode.of(1, 2, 4, 3, 6), s.partition(LinkedListNode.of(3, 4, 2, 6, 1), 5), 5);
    }

    private void assertPartition(LinkedListNode input, LinkedListNode actual, int x) {
        List<Integer> original = toList(input);
        List<Integer> result = toList(actual);

        // Check that elements are the same (ignoring order)
        List<Integer> originalSorted = new ArrayList<>(original);
        List<Integer> resultSorted = new ArrayList<>(result);
        Collections.sort(originalSorted);
        Collections.sort(resultSorted);
        assertEquals("Partitioned list must contain the same elements", originalSorted, resultSorted);

        // Check partition order
        boolean seenRightPartition = false;
        for (int value : result) {
            if (value < x) {
                if (seenRightPartition) {
                    fail("Elements less than x appeared after elements greater than or equal to x");
                }
            } else {
                seenRightPartition = true;
            }
        }
    }

    private List<Integer> toList(LinkedListNode node) {
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
