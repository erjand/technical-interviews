// LeetCode #78
// https://leetcode.com/problems/subsets/ (medium)
//
// Problem Statement:
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.

// Time: O(n * 2^n)
// Space: O(n * 2^n)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        // Declare our result and populate it with an empty set.
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        // Input validation.
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // Iterate through each of the numbers in our input.
        for (int currentNumber : nums) {
            
            // Iterate through all of our currently existing subsets.
            int subSetCount = result.size();
            for (int i = 0; i < subSetCount; i++) {
                
                // And for each one, make a copy and add currentNumber to it.
                ArrayList<Integer> newSubSet = new ArrayList<Integer>(result.get(i));
                newSubSet.add(currentNumber);
                result.add(newSubSet);
            }
        }
        
        return result;
    }
}