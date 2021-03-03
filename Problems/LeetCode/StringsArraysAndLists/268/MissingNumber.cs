// LeetCode #268
// https://leetcode.com/problems/missing-number/
//
// Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

// This solution is more optimal and uses only O(1) space.
// Time: O(n)
// Space: O(1)
public class Solution {
    public int MissingNumber(int[] nums) {
        int numsSum = 0;
        for (int i = 0; i < nums.Length; i++) {
            numsSum += nums[i];
        }
        
        int n = nums.Length + 1;
        int gaussSum = n * (n - 1) / 2;
        
        return gaussSum - numsSum;
    }
}

// This solution uses O(n) memory instead of O(1) but doesn't rely on having to know the Gauss Sum formula.
// Time: O(n)
// Space: O(n)
public class Solution {
    public int MissingNumber(int[] nums) {
        int[] foundNums = new int[nums.Length + 1];
        
        for (int i = 0; i < nums.Length; i++) {
            foundNums[nums[i]] = -1;
        }
        
        for (int i = 0; i < foundNums.Length; i++) {
            if (foundNums[i] != -1) {
                return i;
            }
        }
        
        return -1;
    }
}