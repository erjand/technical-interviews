// LeetCode #136
// https://leetcode.com/problems/single-number/
// 
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

// This simple solution uses a HashSet. The O(1) memory solution uses bit manipulation.

// Time: O(n)
// Space: O(n)
public class Solution {
    public int SingleNumber(int[] nums) {
        HashSet<int> numSet = new HashSet<int>();
        
        for (int i = 0; i < nums.Length; i++) {
            if (numSet.Contains(nums[i])) {
                numSet.Remove(nums[i]);
            } else {
                numSet.Add(nums[i]);
            }
        }
        
        return numSet.FirstOrDefault();
    }
}