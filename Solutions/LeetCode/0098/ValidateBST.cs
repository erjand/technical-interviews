// LeetCode #98
// https://leetcode.com/problems/validate-binary-search-tree/
//
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

// A binary search tree is a binary tree where for every node its left descendents are less than the node's value and its right descendents are greater than the node's value.
// In some cases a BST will allow for things like <= or >=, but in many cases we can safely assume each value is unique.
// This algorithm works by recursively checking each node and updating the min and max values as it goes so that every node is aware of the upper and lower bounds by which it is constrained.
// If the recursive call makes it to the base case where the node is null, then we know it successfully traversed an entire path of the tree with no constraint violations.

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