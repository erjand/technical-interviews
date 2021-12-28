// LeetCode #83
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
// 
// Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

// This algorithm traverses the LinkedList and whenever it finds the current and next node have the same value, 
// it re-assigns current.next to skip over the duplicate value. This dereferences it and allows the GC to clean it up.

// Time: O(n)
// Space: O(1)
public class Solution {
    public ListNode DeleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}