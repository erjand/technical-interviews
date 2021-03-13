// LeetCode #938
// https://leetcode.com/problems/range-sum-of-bst/
//
// Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

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

// This algorithm recurses through our tree and sums as it goes where the value of the targeted node is in range.
// No additional recursive method is necessary in this case since our original method returns an int.

// Time: O(n)
// Space: O(h) where h is the height of the tree
public class Solution {
    public int RangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        int val = 0;
        if (root.val >= low && root.val <= high) {
            val = root.val;
        }

        if (root.left != null && root.right != null) {
            return RangeSumBST(root.left, low, high) + RangeSumBST(root.right, low, high) + val;
        }

        if (root.left != null) {
            return RangeSumBST(root.left, low, high) + val;
        }

        return RangeSumBST(root.right, low, high) + val;
    }
}