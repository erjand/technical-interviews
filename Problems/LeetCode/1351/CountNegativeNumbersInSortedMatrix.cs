// LeetCode #1351
// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
//
// Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

// This is not the most optimal solution. You can improve by either using a binary search on each row, or by tracing the negative numbers from one of the corners.

// Time: O(n * m) 
// Space: O(1)
public class Solution {
    public int CountNegatives(int[][] grid) {
        int negativeCount = 0;
        
        for (int i = 0; i < grid.Length; i++) {
            for (int j = 0; j < grid[i].Length; j++) {
                if (grid[i][j] < 0) {
                    negativeCount += grid[i].Length - j;
                    break;
                }
            }
        }
        
        return negativeCount;
    }
}

// Example:
//  4  3  2 -1
//  3  2  1 -1
//  1  1 -1 -1
// -1 -1 -2 -3