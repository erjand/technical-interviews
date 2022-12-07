// LeetCode #141
// https://leetcode.com/problems/linked-list-cycle/
//
// Given the head of a linked list, determine if the linked list has a cycle in it.
// Can you solve this problem using O(1) memory?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// The first solution to this problem uses additional memory for the HashSet but does not alter the state of the LL.
// The second solution is done in O(1) memory by setting the .next reference of each node back to the head as they are visited.
// This allows us to check the .next pointer of each node as we visit it to see if it points back to the head or not.
// This solution does alter the state of the LL and so would only work in practice if you didn't care about the data structure itself.

// Time: O(n)
// Space: O(n)
public class Solution {
    public bool HasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        HashSet<ListNode> visitedNodeSet = new HashSet<ListNode>();
        ListNode current = head;
        while (current != null) {
            if (visitedNodeSet.Contains(current)) {
                return true;
            }
            visitedNodeSet.Add(current);
            current = current.next;
        }

        return false;
    }
}

// Time: O(n)
// Space: O(1)
public class Solution {
    public bool HasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode current = head;
        while (current != null) {
            if (current.next == head) {
                return true;
            }
            ListNode temp = current.next;
            current.next = head;
            current = temp;
        }

        return false;
    }
}