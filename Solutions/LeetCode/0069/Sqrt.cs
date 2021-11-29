// LeetCode #69
// https://leetcode.com/problems/sqrtx/
//
// Given a non-negative integer x, compute and return the square root of x.
// Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

// guess > x / guess is used instead of guess * guess == x to avoid int overflow
// This solution uses binary search vs iterating 1 ... x

// Time: O(log n)
// Space: O(1)
public class Solution {
    public int MySqrt(int x) {
        if (x == 0) return 0;
        
        int min = 1;
        int max = x;
        
        while (true) {
            int guess = min + (max - min) / 2;
            if (guess > x / guess) {
                max = guess - 1;
            } else {
                if (guess + 1 > x / (guess + 1)) {
                    return guess;
                }
                min = guess + 1;
            }
        }
    }
}