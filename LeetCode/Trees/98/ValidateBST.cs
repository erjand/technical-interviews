// LeetCode #98
// https://leetcode.com/problems/validate-binary-search-tree/
// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

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
 // Time: O(n)
 // Space: O(h) where h is the height of the tree
public class Solution {
    public bool IsValidBST(TreeNode root) {
        return Valid(root, null, null);
    }

    public bool Valid(TreeNode node, int? min, int? max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val <= min || max != null && node.val >= max) {
            return false;
        }

        return Valid(node.left, min, node.val) && Valid(node.right, node.val, max);
    }
}