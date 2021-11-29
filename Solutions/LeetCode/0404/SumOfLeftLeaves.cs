// LeetCode #404
// https://leetcode.com/problems/sum-of-left-leaves/
//
// Find the sum of all left leaves in a given binary tree.

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

// Similar to other binary tree summing algorithms, but the difference here is we only care about bringing the 
// root.val with us if we know it's a left leaf, in which case we also know to just continue the recursion on
// the right child only.
// Otherwise we just keep recursing normally on both left and right.

// Time: O(n)
// Space: O(h) where h is maximum height of the tree
public class Solution {
    public int SumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.left.left == null && root.left.right == null) {
            return SumOfLeftLeaves(root.right) + root.left.val;
        }

        return SumOfLeftLeaves(root.left) + SumOfLeftLeaves(root.right);
    }
}