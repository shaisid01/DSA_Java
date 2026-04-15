package dsa.LinkedListStackQueue;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DetectCycleTest {

    @Test
    void testNoCycle() {
        DetectCycle.ListNode head = new DetectCycle.ListNode(1);
        head.next = new DetectCycle.ListNode(2);
        head.next.next = new DetectCycle.ListNode(3);

        assertFalse(DetectCycle.hasCycle(head));
    }

    @Test
    void testCycleExists() {
        DetectCycle.ListNode head = new DetectCycle.ListNode(1);
        DetectCycle.ListNode node2 = new DetectCycle.ListNode(2);
        DetectCycle.ListNode node3 = new DetectCycle.ListNode(3);
        DetectCycle.ListNode node4 = new DetectCycle.ListNode(4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 🔥 Create cycle: 4 → 2
        node4.next = node2;

        assertTrue(DetectCycle.hasCycle(head));
    }

    @Test
    void testCycleAtHead() {
        DetectCycle.ListNode head = new DetectCycle.ListNode(1);
        DetectCycle.ListNode node2 = new DetectCycle.ListNode(2);

        head.next = node2;

        // 🔥 Cycle back to head: 2 → 1
        node2.next = head;

        assertTrue(DetectCycle.hasCycle(head));
    }

    @Test
    void testSingleNodeNoCycle() {
        DetectCycle.ListNode head = new DetectCycle.ListNode(1);

        assertFalse(DetectCycle.hasCycle(head));
    }

    @Test
    void testSingleNodeWithCycle() {
        DetectCycle.ListNode head = new DetectCycle.ListNode(1);

        // 🔥 Node points to itself
        head.next = head;

        assertTrue(DetectCycle.hasCycle(head));
    }
}