// LeetCode #448
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// 
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

// This solution uses the value of the number for the actual index in the new array so we can iterate through the new array and just check for any
// values that are still set to the default value of 0.
// This problem can also be solved using O(1) space by following a similar pattern but flipping each number to a negative as you iterate through the array,
// and then when you check the numbers on a second pass you look for any that are still positive.

// Time: O(n) 
// Space: O(n)
public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        int[] foundNums = new int[nums.Length + 1];
        List<int> missingNumList = new List<int>();
        
        for (int i = 0; i < nums.Length; i++) {
            foundNums[nums[i]] = nums[i];
        }
        
        for (int i = 1; i < foundNums.Length; i++) {
            if (foundNums[i] == 0) {
                missingNumList.Add(i);
            }
        }
        
        return missingNumList;
    }
}