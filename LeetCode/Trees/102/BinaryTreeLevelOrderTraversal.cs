// LeetCode #102
// https://leetcode.com/problems/binary-tree-level-order-traversal/
//
// Given a binary tree, return the level order traversal of its nodes' values.

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

// Level Order Traversal of a tree is essentially a Breadth First Search (BFS).
// The standard BFS implementation uses a queue, where as every node is visited all of its adjacent nodes get added to the queue for future processing.

 // Time: O(n)
 // Space: O(w) where w is the max width of the tree
public class Solution {
    public IList<IList<int>> LevelOrder(TreeNode root) {
        List<IList<int>> valueList = new List<IList<int>>();
        if (root == null) return valueList;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count != 0) {
            int count = queue.Count;
            List<int> levelValueList = new List<int>();
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.Dequeue();
                levelValueList.Add(currentNode.val);
                if (currentNode.left != null) {
                    queue.Enqueue(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.Enqueue(currentNode.right);
                }
            }
            valueList.Add(levelValueList);
        }

        return valueList;
    }
}