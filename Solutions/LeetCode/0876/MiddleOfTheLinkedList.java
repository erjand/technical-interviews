// LeetCode #876
// https://leetcode.com/problems/middle-of-the-linked-list/

// Given the head of a singly linked list, return the middle node of the linked list.
// If there are two middle nodes, return the second middle node.

// This is a classic slow and fast pointer problem.
// You could solve this with a two-pass by getting the length of the Linked List on the 
// first pass and then stopping in the middle on the second pass.
// However, if you use the fast and slow pointer, you can solve it in a single pass.

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
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return slow;
            }
            
        }

        return slow;
    }
}