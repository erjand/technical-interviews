// LeetCode #112
// https://leetcode.com/problems/path-sum/
//
// Given the root of a binary tree and an integer targetSum, return true if the tree 
// has a root-to-leaf path such that adding up all the values along the path equals targetSum.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // Time: O(n) in the worst-case if we traverse every node on the tree.
 // Space: O(n) in the worst-case if the tree is a LinkedList (vertical).
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If the node is null, we did not find a valid path to sum.
        if (root == null) {
            return false;
        }

        // If we are on a leaf node and our remaining sum equals the value of the node, 
        // then we found a valid path to sum.
        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        // Otherwise, continue to recursively traverse the tree.
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}