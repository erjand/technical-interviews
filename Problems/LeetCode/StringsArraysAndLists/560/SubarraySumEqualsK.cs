// LeetCode #560
// https://leetcode.com/problems/subarray-sum-equals-k/
//
// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.

// If the array specified only positive integers, we could bail out of the second for loop as soon as sum >= k

// Time: O(n^2)
// Space: O(1)
public class Solution {
    public int SubarraySum(int[] nums, int k) {
        int subArrayCount = 0;
        int sum = 0;
        for (int i = 0; i < nums.Length; i++) {
            sum = nums[i];
            if (sum == k) {
                subArrayCount++;
            }
            
            for (int j = i + 1; j < nums.Length; j++) {
                sum += nums[j];
                
                if (sum == k) {
                    subArrayCount++;
                }
            }
        }
        
        return subArrayCount;
    }
}