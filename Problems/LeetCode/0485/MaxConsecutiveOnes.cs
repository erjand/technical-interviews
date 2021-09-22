// LeetCode #485
// https://leetcode.com/problems/max-consecutive-ones/
//
// Given a binary array, find the maximum number of consecutive 1s in this array.

// If we were dealing with a more complex sequence other than 0 and 1, this could be a potential candidate for a sliding window algorithm (which would work).
// However since we are literally just counting 1s and resetting our count at 0s we can simply iterate and count or reset.

// Time: O(n)
// Space: O(1)
public class Solution {
    public int FindMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int currentCount = 0;
        
        for (int i = 0; i < nums.Length; i++) {
            if (nums[i] == 1) {
                currentCount++;
                maxCount = Math.Max(maxCount, currentCount);
            } else {
                currentCount = 0;
            }
            
        }
        
        return maxCount;
    }
}