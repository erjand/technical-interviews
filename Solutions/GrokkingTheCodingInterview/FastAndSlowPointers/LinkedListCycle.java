// From the educative.io course "Grokking the Coding Interview".
// Pattern: Fast and Slow Pointers.
// Problem: LinkedList Cycle (easy).
//
// Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.

class ListNode {
    int value = 0;
    ListNode next;

    ListNode(int value) {
        this.value = value;
    }
}

// Time: O(n)
// Space: O(1)
public static boolean hasCycle(ListNode head) {
    
    ListNode slow = head;
    ListNode fast = head.next;

    while (slow != fast) {
        if (fast == null || fast.next == null) {
            return false;
        }

        slow = slow.next;
        fast = fast.next.next;
    }

    return true;
}