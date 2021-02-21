// LeetCode #101
// https://leetcode.com/problems/symmetric-tree/
//
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

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

// This algorithm uses a straight-forward recursive binary tree traversal approach and just checks the value of each node, 
// and then what should be the symmetric subtrees of each node (left.left, right.right) and (left.right, right.left).

// Time: O(n) 
// Space: O(h) where h is the max height of the tree
public class Solution {
    public bool IsSymmetric(TreeNode root) {
        if (root == null) return true;
        return Sym(root.left, root.right);
    }

    public bool Sym(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        
        if (left.val != right.val) {
            return false;
        }

        return Sym(left.left, right.right) && Sym(left.right, right.left);
    }
}