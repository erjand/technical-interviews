// LeetCode #217
// https://leetcode.com/problems/contains-duplicate/
// 
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// This is a trivial problem that does a good job highlighting space / time tradeoffs.
// A brute force solution with nested loops is O(n^2) time and O(1) space.
// Sorting the array first and then checking each subsequent number in the array is O(n logn) time and O(1) space.
// The solution below using a HashSet is O(n) time and O(n) space.

// Time: O(n)
// Space: O(n)
public class Solution {
    public bool ContainsDuplicate(int[] nums) {
        HashSet<int> numSet = new HashSet<int>();
        
        for (int i = 0; i < nums.Length; i++) {
            if (numSet.Contains(nums[i])) {
                return true;
            }
            else {
                numSet.Add(nums[i]);
            }
        }
        
        return false;
    }
}