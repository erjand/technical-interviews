// From the educative.io course "Grokking the Coding Interview".
// Pattern: In-Place Reversal of a LinkedList
// Problem: Reverse a Sub-list (medium)
// Similar LeetCode Problem: https://leetcode.com/problems/reverse-linked-list-ii/

// Problem Statement:
// Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.

// Solution Notes:
// This problem uses the strategy from ReverseLinkedList to reverse the nodes from position p to q, but with
// the added challenge of having to re-attached the reversed portion at the front and the back.
// This can be accomplished by storing the lastUntouchedNode (will attach to the back of the new reversed list) 
// and lastReversedNode (will attach at the head of the new reversed list).

// Time: O(n)
// Space: O(1)
public static ListNode reverse(ListNode head, int p, int q) {
    
    // Input validation.
    if (head == null || p == q) {
        return head;
    }

    // Traverse the LinkedList until the node at index p.
    ListNode current = head;
    ListNode previous = null;
    for (int i = 0; current != null && i < p - 1; i++) {
        previous = current;
    }
        current = current.next;

    // Set variables.
    ListNode lastUntouchedNode = previous;
    ListNode lastReversedNode = current;
    ListNode next = null;

    // Perform the standard in-place reversal for nodes p through q.
    for (int i = 0; current != null && i < q - p + 1; i++) {
        next = current.next;
        current.next = previous;
        previous = current;
        current = next;
    }

    // Re-attach the reversed list at the front and back.
    // If lastUntouchedNode is null that means our reversal started with the first node, and 
    // we need to use previous as the new head.
    if (lastUntouchedNode == null) {
        head = previous;
    } else {
        lastUntouchedNode.next = previous;
    }
    lastReversedNode.next = current;

    return head;
}
