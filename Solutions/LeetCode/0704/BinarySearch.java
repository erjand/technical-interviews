/*
=== Problem Source ===
LeetCode #704 - https://leetcode.com/problems/binary-search/

=== Problem Statement ===
Given an array of integers nums which is sorted in ascending order, and an integer target, 
write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

=== Complexity ===
Time: O(logn)
Space: O()

Binary Search has an O(logn) runtime like many other searching algorithms.
This is due to the fact that the remaining dataset is halved after each search operation.

In this case our input is already sorted we can reliably expect O(logn).
If the input were unsorted, we would have a worst-case runtime of O(n) in case each element had to be
examined before we found the target (or found no element matching the target).

*/
class Solution {
    public static void main(String[] args) {
        int result = search(new int[] {-1, 0, 3, 5, 9, 12}, 9);
        System.out.println(result);
    }

    public static int search(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        int pivotIndex = 0;
        
        while (startIndex <= endIndex) {
            pivotIndex = startIndex + (endIndex - startIndex) / 2;
            int pivotResult = nums[pivotIndex];          
            
            // Found a match.
            if (pivotResult == target) {
                return pivotIndex;
            } else if (pivotResult > target) { // Too high; search left.
                endIndex = pivotIndex - 1;
            } else { // Too low; search right.
                startIndex = pivotIndex + 1;
            }
        }
        
        // No match found.
        return -1;
    }
}
