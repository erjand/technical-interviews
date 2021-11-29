// From the educative.io course "Grokking the Coding Interview".
// Pattern: Two Pointers.
//
// Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
// Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

// Time: O(n)
// Space: O(1)
public static int[] search(int[] arr, int targetSum) {
    int startPointer = 0;
    int endPointer = arr.length - 1;
    
    while (startPointer < endPointer) {
        int pointerSum = arr[startPointer] + arr[endPointer];
        if (pointerSum > targetSum) {
            endPointer--;
        } else if (pointerSum < targetSum) {
            startPointer++;
        } else if (pointerSum == targetSum) {
            return new int[] { startPointer, endPointer };
        }
    }
    
    return new int[] { -1, -1 };
}