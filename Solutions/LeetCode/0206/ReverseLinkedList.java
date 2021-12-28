// LeetCode #206
// https://leetcode.com/problems/reverse-linked-list/
//
// Given the head of a singly linked list, reverse the list, and return the reversed list.

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
    public ListNode reverseList(ListNode head) {
        // Input validation.
        if (head == null || head.next == null) {
            return head;
        }
        
        // Setup variables.
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;
        
        // Traverse and reverse the LinkedList.
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        
        // Re-assign the head of the LinkedList to what is now the beginning.
        head = previous;
        
        return head;
    }
}