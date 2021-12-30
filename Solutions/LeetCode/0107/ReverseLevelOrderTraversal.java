// LeetCode #107
// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//
// Given the root of a binary tree, return the bottom-up level order traversal 
// of its nodes' values. (i.e., from left to right, level by level from leaf to root).

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

 // Time: O(n) to traverse all nodes in the tree.
 // Space: O(n) to store the value of all nodes in the tree.
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
    
        // Input validation.
        if (root == null) {
            return result;
        }

        // We solve this problem in the same way as the normal level-order traversal,
        // but will use a Stack to reverse the levels at the end.
        Stack<List<Integer>> levelStack = new Stack<List<Integer>>();

        // Queue is an Interface in Java, with LinkedList being the implementation.
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>(); 

        // Populate our queue with the provided root.
        nodeQueue.offer(root);

        // Continue traversing the tree while our queue has items.
        while (!nodeQueue.isEmpty()) {

            // The number of items in the queue determines how many nodes are in this level.
            int levelNodeCount = nodeQueue.size();
            List<Integer> levelValueList = new ArrayList<Integer>();

            // Process all of the nodes in this level; adding their children to the queue as we go.
            for (int i = 0; i < levelNodeCount; i++) {
                TreeNode currentNode = nodeQueue.poll();
                levelValueList.add(currentNode.val);

                if (currentNode.left != null) {
                    nodeQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    nodeQueue.offer(currentNode.right);
                }
            }

            // Push our new levelValueList onto the stack.
            levelStack.push(levelValueList);
        }

        // Pop all of the items in our stack into our result: the reverse level-order traversal.
        while (!levelStack.isEmpty()) {
            result.add(levelStack.pop());
        }

        return result;
    }
}