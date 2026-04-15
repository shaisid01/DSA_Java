package dsa.LinkedListStackQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class ReverseLinkedListTest {

    @Test
    void testReverseList() {
        // Create list: 1 -> 2 -> 3 -> 4 -> null
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);
        head.next.next.next = new ReverseLinkedList.ListNode(4);

        // Reverse it
        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverseList(head);

        // Verify: 4 -> 3 -> 2 -> 1 -> null
        assertEquals(4, reversed.val);
        assertEquals(3, reversed.next.val);
        assertEquals(2, reversed.next.next.val);
        assertEquals(1, reversed.next.next.next.val);
        assertNull(reversed.next.next.next.next);
    }

    @Test
    void testEmptyList() {
        assertNull(ReverseLinkedList.reverseList(null));
    }

    @Test
    void testSingleNode() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    void testTwoNodes() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    void testDuplicates() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(2);
        head.next.next.next = new ReverseLinkedList.ListNode(1);

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(1, result.next.next.next.val);
    }

    @Test
    void testLongList() {
    ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
    ReverseLinkedList.ListNode curr = head;

    for (int i = 2; i <= 10; i++) {
        curr.next = new ReverseLinkedList.ListNode(i);
        curr = curr.next;
    }

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        // Check first and last few nodes
        assertEquals(10, result.val);
        assertEquals(9, result.next.val);

        // Traverse to end
        curr = result;
        while (curr.next != null) {
            curr = curr.next;
        }

        assertEquals(1, curr.val);
    }

    @Test
    void testCleanAssertion() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1);
        head.next = new ReverseLinkedList.ListNode(2);
        head.next.next = new ReverseLinkedList.ListNode(3);

        ReverseLinkedList.ListNode result = ReverseLinkedList.reverseList(head);

        assertArrayEquals(new int[]{3, 2, 1}, toArray(result));
    }

    private int[] toArray(ReverseLinkedList.ListNode head) {
    java.util.List<Integer> list = new java.util.ArrayList<>();
    while (head != null) {
        list.add(head.val);
        head = head.next;
    }
    return list.stream().mapToInt(i -> i).toArray();
    }
}