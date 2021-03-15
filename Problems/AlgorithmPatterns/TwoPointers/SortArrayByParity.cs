// LeetCode #905
// https://leetcode.com/problems/sort-array-by-parity/
//
// Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

// This solution uses two pointers (start and end) to put all the even numbers starting at the beginning and all the odd numbers starting at the end.

// Time: O(A)
// Space: O(A)
public class Solution {
    public int[] SortArrayByParity(int[] A) {
        int[] sortedArray = new int[A.Length];
        
        int start = 0;
        int end = A.Length - 1;
        
        for (int i = 0; i < A.Length; i++) {
            if (A[i] % 2 == 0) {
                sortedArray[start] = A[i];
                start++;
            } else {
                sortedArray[end] = A[i];
                end--;
            }
        }
        
        return sortedArray;
    }
}