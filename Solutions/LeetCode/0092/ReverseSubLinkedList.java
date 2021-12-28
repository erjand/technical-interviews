// LeetCode #92
// https://leetcode.com/problems/reverse-linked-list-ii/
// 
// Given the head of a singly linked list and two integers left and right where left <= right, 
// reverse the nodes of the list from position left to position right, and return the reversed list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time: O(n)
// Space: O(1)
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Input validation.
        if (head == null || left == right) {
            return head;
        }

        // Traverse the LinkedList until the node at index p.
        ListNode current = head;
        ListNode previous = null;
        for (int i = 0; current != null && i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        // Set variables.
        ListNode lastUntouchedNode = previous;
        ListNode lastReversedNode = current;
        ListNode next = null;

        // Perform the standard in-place reversal for nodes p through q.
        for (int i = 0; current != null && i < right - left + 1; i++) {
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
}