// LeetCode #111
// https://leetcode.com/problems/minimum-depth-of-binary-tree/
//
// Given a binary tree, find its minimum depth.

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

// The first solution is a tree traversal to find the min depth, with just some additional null checking to make sure that null branches don't incorrectly count as short depths.
// The second solution uses a level-order traversal (BFS) for an iterative solution to find the first instance of a leaf node, which it knows will be the min depth.

// Time: O(n)
// Space: O(h) where h is the height of the tree
public class Solution {
    public int MinDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left != null && root.right != null) {
            return Math.Min(MinDepth(root.left), MinDepth(root.right)) + 1;
        }

        if (root.left != null) return MinDepth(root.left) + 1;
        return MinDepth(root.right) + 1;
    }
}

// Time: O(n)
// Space: O(w) where w is the max width of the tree
public class Solution { 
    public int MinDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        int depth = 0;

        while (queue.Count != 0) {
            depth++;
            int count = queue.Count;
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.Dequeue();
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                if (currentNode.left != null) {
                    queue.Enqueue(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.Enqueue(currentNode.right);
                }
            }
        }

        return depth;
    }
}