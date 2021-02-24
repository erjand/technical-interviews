// LeetCode #1161
// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
//
// Given the root of a binary tree, return the level x which has the maximum sum of all values in a level.

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

// This algorithm builds on top of a standard level-order traversal (BFS) 
// and keeps running counters for both the current level and level sums as well as the previous best sum and level.
// One important thing to note is that we need to initialize our maxLevelValue to Int32.MinValue 
// instead of 0 so that negative sums are still tallied and considered (if every row has a negative sum, one of them is still "best" even if they are all negative).

// Time: O(n)
// Space: O(w) where w is max width of tree
public class Solution {
    public int MaxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        int maxLevelValue = Int32.MinValue;
        int maxDepth = 0;
        int currentDepth = 0;

        while (queue.Count != 0) {
            int count = queue.Count;
            int levelValue = 0;
            currentDepth++;
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.Dequeue();
                levelValue += currentNode.val;
                if (currentNode.left != null) queue.Enqueue(currentNode.left);
                if (currentNode.right != null) queue.Enqueue(currentNode.right);
            }

            if (levelValue > maxLevelValue) {
                maxLevelValue = levelValue;
                maxDepth = currentDepth;
            }
        }

        return maxDepth;
    }
}