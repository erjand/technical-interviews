// LeetCode #167
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// 
// Given an array of integers numbers that is already sorted in ascending order, 
// find two numbers such that they add up to a specific target number.
// Return the indices of the two numbers (1-indexed) as an integer array answer of size 2, where 1 <= answer[0] < answer[1] <= numbers.length.
// You may assume that each input would have exactly one solution and you may not use the same element twice.

// See LC #1 for the unsorted version of this problem using a Dictionary.
// When the array is sorted, it can be solved in O(1) space by using two pointers at the start and end.

// Time: O(n)
// Space: O(1)
public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        if (numbers == null) return null;

        int start = 0;
        int end = numbers.Length - 1;

        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[2] { start + 1, end + 1};
            }

            if (numbers[end] > target) {
                end--;
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }

        return new int[2];
    }
}