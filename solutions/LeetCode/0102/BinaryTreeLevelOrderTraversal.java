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

// Time: O(n)
// Space: O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            List<Integer> levelList = new ArrayList<Integer>();
            
            for (int i = 0; i < levelCount; i++) {
                TreeNode current = queue.poll();
                levelList.add(current.val);
                
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
            
            result.add(levelList);
        }
        
        return result;
    }
}