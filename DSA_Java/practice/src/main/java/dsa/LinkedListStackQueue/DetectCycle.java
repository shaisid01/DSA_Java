/*Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false. */

/*
Idea (Tortoise & Hare)

Use two pointers:

slow → moves 1 step
fast → moves 2 steps

If there is a cycle, they will eventually meet
If not, fast will hit null

Time: O(n)
Space: O(1) (no extra memory)
*/


package dsa.LinkedListStackQueue;

public class DetectCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Returns true if cycle exists
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                return true;           // cycle detected
            }
        }

        return false; // no cycle
    }
}