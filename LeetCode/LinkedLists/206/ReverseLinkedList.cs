// LeetCode #206
// https://leetcode.com/problems/reverse-linked-list/
//
// Given the head of a singly linked list, reverse the list, and return the reversed list.

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

// This algorithm uses the standard while loop that is common to many LL problems in order to iterate through all nodes.
// As we go, we just use the temp node to make sure that we can point back, but also still keep moving forward.
// Once we get through the whole LL, all our nodes are now pointing back to the node before them, and we can return
// "prev" which will be the last LL node that isn't null.

// Time: O(n)
// Space: O(1)
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}