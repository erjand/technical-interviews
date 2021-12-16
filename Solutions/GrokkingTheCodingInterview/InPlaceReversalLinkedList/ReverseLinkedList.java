// From the educative.io course "Grokking the Coding Interview".
// Pattern: In-Place Reversal of a LinkedList
// Problem: Reverse a LinkedList (easy)

// Problem Statement:
// Given the head of a Singly LinkedList, reverse the LinkedList. Write a function to return the new head of the reversed LinkedList.

// Solution Notes:
// This problem can also be solved with a Stack<ListNode>, but that uses O(n) space and is less ideal.

// Time: O(n)
// Space: O(1)
public static ListNode reverse(ListNode head) {
    // Input validation.
    if (head == null || head.next == null) {
        return head;
    }

    // Setup node pointers.
    ListNode previous = null;
    ListNode current = head;
    ListNode next = null;

    // Traverse the LinkedList.
    while (current != null) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }

    // Set head to the back of the reversed list.
    head = previous;
    return head;
}