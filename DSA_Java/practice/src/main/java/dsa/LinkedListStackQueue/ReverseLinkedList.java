/*Given the head of a singly linked list, reverse the list, and return the reversed list. */
/*Traverse the list and reverse the next pointers one by one.
Time: O(n)
Space:Iterative → O(1)
*/

package dsa.LinkedListStackQueue;

public class ReverseLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Iterative method to reverse the list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next; // store next
            curr.next = prev;              // reverse pointer
            prev = curr;                  // move prev
            curr = nextTemp;              // move curr
        }

        return prev; // new head
    }

    // Helper method to print the list
    public static void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        // Create list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.print("Original: ");
        printList(head);

        head = reverseList(head);

        System.out.print("Reversed: ");
        printList(head);
    }
}