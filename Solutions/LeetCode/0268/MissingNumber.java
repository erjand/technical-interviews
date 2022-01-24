// LeetCode #268
// https://leetcode.com/problems/missing-number/
//
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// Time: O(n)
// Space: O(1)
class Solution {
    public int missingNumber(int[] nums) {
        // Input validation.
        if (nums == null) {
            return -1;
        }

        // Perform cyclic sort.
        int i = 0;
        while (i < nums.length) {
            if (nums[i] < nums.length && nums[i] != i) {
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        // Find the missing number.
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        // Covers the edge case where input is already in order.
        // Ex: [0, 1]
        return nums.length;
    }
}