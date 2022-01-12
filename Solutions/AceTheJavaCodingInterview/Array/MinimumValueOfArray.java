/*
Tags: #array

Problem Source:
From the educative.io course "Ace the Java Coding Interview"

Problem Statement:
Given an array of size "n", find the minimum value in the array.
*/

// Time: O(n)
// Space: O(1)
public static int findMinimum(int[] arr) {
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
        min = Math.min(arr[i], min);
    }

    return min;
}
