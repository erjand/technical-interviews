// LeetCode #448
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
// 
// Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

// This solution uses a second array to mark found numbers with -1, and then checks for 0's to find missing numbers.
// Time: O(n)
// Space: O(n)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        
        int[] foundArray = new int[nums.length + 1];
        
        for (int i = 0; i < nums.length; i++) {
            foundArray[nums[i]] = -1;
        }
        
        List<Integer> disappearedList = new ArrayList<Integer>();
        
        for (int i = 1; i < foundArray.length; i++) {
            if (foundArray[i] == 0) {
                disappearedList.add(i);
            }
        }
        
        return disappearedList;
    }
}

// This solution improves on the one above by instead just flipping the sign of each number in place to negative once it is found.
// Time: O(n)
// Space: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
                
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] >= 0) {
                nums[index] = nums[index] * -1;
            }
        }
        
        List<Integer> disappearedList = new ArrayList<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                disappearedList.add(i + 1);
            }
        }
        
        return disappearedList;
    }
}