// LeetCode #217
// https://leetcode.com/problems/contains-duplicate/
// 
// Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

// Time: O(n)
// Space: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numHash = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (numHash.contains(nums[i])) {
                return true;
            } else {
                numHash.add(nums[i]);
            }
        }

        return false;
    }
}