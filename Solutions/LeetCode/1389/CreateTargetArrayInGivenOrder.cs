// LeetCode #1389
// https://leetcode.com/problems/create-target-array-in-the-given-order/
//
// Given two arrays of integers nums and index. Your task is to create target array under the following rules:
//     Initially target array is empty.
//     From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
//     Repeat the previous step until there are no elements to read in nums and index.
// Return the target array.
// It is guaranteed that the insertion operations will be valid.

// This solution takes advantage of the built-in List<T>.Insert C# method, which handles resizing as needed.

// Time: O(n * k) where n is the length of nums and k is the number of times the indices have to be shifted
// Space: O(n)
public class Solution {
    public int[] CreateTargetArray(int[] nums, int[] index) {
        List<int> targetList = new List<int>();
        
        for (int i = 0; i < nums.Length; i++) {
            targetList.Insert(index[i], nums[i]);
        }
        
        return targetList.ToArray();
    }
}