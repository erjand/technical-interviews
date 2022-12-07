// LeetCode #977
// https://leetcode.com/problems/squares-of-a-sorted-array/
//
// Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

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

// Time: O(n * 2), which is O(n)
// Space: O(n * 2), which is O(n)
class Solution {
    public int[] sortedSquares(int[] nums) {
        if (nums == null) {
            return null;
        }
        
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            int square = nums[i] * nums[i];
            result[i] = square;
        }
        
        int[] sorted = Arrays.stream(result).sorted().toArray();
        
        return sorted;
    }
}