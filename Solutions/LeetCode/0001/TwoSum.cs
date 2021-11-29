// LeetCode #1
// https://leetcode.com/problems/two-sum/
// 
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

// The niave solution to this problem is a brute force n^2 approach with a nested for loop.
// Using a dictionary for the value and it's index plus calculating the target complement for each value i 
// allows us to do it in one pass, but still uses O(n) space.
// If you have a sorted array, you can use a two pointers approach (one at the start and one at the end) 
// to solve this in O(1) space (see problem #167).
// If you need to sort the array yourself, you can do so with O(n logn) time and then have O(1) space.

// Time: O(n)
// Space: O(n)
public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        if (nums == null) return null;

        Dictionary<int, int> numDict = new Dictionary<int, int>();
        numDict.Add(nums[0], 0);

        for (int i = 1; i < nums.Length; i++) {
            int complement = target - nums[i];
            if (numDict.ContainsKey(complement)) {
                return new int[2] { i, numDict[complement] };
            }
            numDict.Add(nums[i], i);
        }

        return new int[2];
    }
}