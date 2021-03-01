// LeetCode #852
// https://leetcode.com/problems/peak-index-in-a-mountain-array/
//
// Let's call an array arr a mountain if the following properties hold:

//     arr.length >= 3
//     There exists some i with 0 < i < arr.length - 1 such that:
//         arr[0] < arr[1] < ... arr[i-1] < arr[i]
//         arr[i] > arr[i+1] > ... > arr[arr.length - 1]

// Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

// Time: O(log n) using binary search
// Space: O(1)
public class Solution {
    public int PeakIndexInMountainArray(int[] arr) {
        int guess = arr.Length / 2;
        int min = 0;
        int max = arr.Length - 1;

        while (true) {
            if (arr[guess] > arr[guess + 1] && arr[guess - 1] < arr[guess]) {
                return guess;
            } else if (arr[guess + 1] > arr[guess]) {
                min = guess + 1;
            } else {
                max = guess - 1;
            }
            guess = (max + min) / 2;
        }
    }
}

// Example: 
// [24,69,100,99,79,78,67,36,26,19]