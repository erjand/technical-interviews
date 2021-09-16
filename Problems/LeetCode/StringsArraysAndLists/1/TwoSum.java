// LeetCode #1
// https://leetcode.com/problems/two-sum/
//
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberMap = new HashMap<>() {};

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numberMap.containsKey(complement)) {
                return new int[] {numberMap.get(complement), i};
            } else {
                numberMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }
}