// LeetCode #104
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
//
// Given the root of a binary tree, return its maximum depth.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// This algorithm uses a straight-forward recursive binary tree traversal approach and increments the total for each level.
// No additional recursive algorithm is necessary since the original one already has an int return type, which we can leverage to keep a running total of the current depth.

// Time: O(n)
// Space: O(h) where h is the max height of the tree
public class Solution {
    public int MaxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.Max(MaxDepth(root.left), MaxDepth(root.right)) + 1;
    }
}