// LeetCode #113
// https://leetcode.com/problems/path-sum-ii/ (medium)
//
// Given the root of a binary tree and an integer targetSum, 
// return all root-to-leaf paths where the sum of the node values in the path equals targetSum. 
// Each path should be returned as a list of the node values, not node references.
// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

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

 // Time: O(n logn)
 // Space: O(n logn)
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<Integer>();

        // Because our recursive method returns void, we take advantage of passing allPaths by reference.
        findAllPaths(root, targetSum, allPaths, currentPath);
        return allPaths;
    }

    public static void findAllPaths(TreeNode node, int sum, List<List<Integer>> allPaths, List<Integer> currentPath) {
        // If we made it to a null node, then there was no valid path.
        if (node == null) {
            return;
        }

        currentPath.add(node.val);

        // If we are on a leaf node, check for the targetSum.
        if (node.left == null && node.right == null && node.val == sum) {
            allPaths.add(new ArrayList<Integer>(currentPath));
        } 
        // Otherwise, continue recursing the tree.
        else {
            findAllPaths(node.left, sum - node.val, allPaths, currentPath);
            findAllPaths(node.right, sum - node.val, allPaths, currentPath);
        }

        // Remove the node from our current path and go back up a level.
        currentPath.remove(currentPath.size() - 1);
    }
}