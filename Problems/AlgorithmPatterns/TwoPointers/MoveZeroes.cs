// LeetCode #283
// https://leetcode.com/problems/move-zeroes/
//
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
// You must do this in-place without making a copy of the array.
// Minimize the total number of operations.

// This solution use a standard two-pointer approach so we can always swap the element we are looking at 
// with the next non-zero element that our fast pointer has found. 
// This allows us to edit the array in place and do the movement for all zereos in a single pass.

// Time: O(n)
// Space: O(1)
public class Solution {
    public void MoveZeroes(int[] nums) {
        if (nums == null || nums.Length == 0 || nums.Length == 1) {
            return;
        }

        int start = 0;
        int end = 1;
        while (start < nums.Length - 1) {
            if (nums[start] == 0 && end < nums.Length) {
                while (end < nums.Length - 1 && nums[end] == 0) {
                    end++;
                }
                nums[start] = nums[end];
                nums[end] = 0;
            }

            start++;
            end = start + 1;
        }
    }
}