// LeetCode #160
// https://leetcode.com/problems/intersection-of-two-linked-lists/
//
// Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */

 // Time: O(a + b)
 // Space: O(a)
 // This could be done in O(1) memory by getting the length of each LL and then aligning their start points, and incrementing them together until a match or null is found.
public class Solution {
    public ListNode GetIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> seenNodeSet = new HashSet<ListNode>();
        
        ListNode current = headA;
        while (current != null) {
            seenNodeSet.Add(current);
            current = current.next;
        }
        
        current = headB;
        while (current != null) {
            if (seenNodeSet.Contains(current)) {
                return current;
            }
            else {
                seenNodeSet.Add(current);
            }
            current = current.next;
        }
        
        return null;
    }
}