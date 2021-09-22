// LeetCode #637
// https://leetcode.com/problems/average-of-levels-in-binary-tree/
//
// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array. 

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

// This problem uses a standard level-order traversal of the binary tree and calculates the averages of each level as it goes.
// Note that using double for the type on the levelValueCount and levelValueSum ensures the division operation returns a non-rounded double.

// Time: O(n)
// Space: O(l) where l is the maximum width of the tree
public class Solution {
    public IList<double> AverageOfLevels(TreeNode root) {
        List<double> averagesList = new List<double>();
        
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        
        while (queue.Count != 0) {
            int count = queue.Count;
            double levelValueCount = 0;
            double levelValueSum = 0;
            double levelValueAverage = 0;
            for (int i = 0; i < count; i++) {
                TreeNode currentNode = queue.Dequeue();
                levelValueCount++;
                levelValueSum += currentNode.val;
                
                if (currentNode.left != null) {
                    queue.Enqueue(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.Enqueue(currentNode.right);
                }
            }
            
            levelValueAverage = levelValueSum / levelValueCount;
            averagesList.Add(levelValueAverage);
        }
        
        return averagesList;
    }
}