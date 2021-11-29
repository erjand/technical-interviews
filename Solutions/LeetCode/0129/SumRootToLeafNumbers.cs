// LeetCode #129
// https://leetcode.com/problems/sum-root-to-leaf-numbers/
//
// You are given the root of a binary tree containing digits from 0 to 9 only.
// Each root-to-leaf path in the tree represents a number.
// Return the total sum of all root-to-leaf numbers.

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

// Unlike some other tree summing problems, for this one we do actually want a second recursive method
// so that we can utilize the sum parameter for keeping the total number so far.
// Multipling the sum by 10 and then adding the current node value allows us to construct "12" from "1" and "2", etc.

// Time: O(n)
// Space: O(h) where h is the max height of the tree
public class Solution {
    public int SumNumbers(TreeNode root) {
        if (root == null) return 0;
        return Sum(root, 0);
    }

    public int Sum(TreeNode node, int sum) {
        if (node == null) return 0;

        sum = sum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return sum;
        }

        return Sum(node.left, sum) + Sum(node.right, sum);
    }
}