// From the educative.io course "Grokking the Coding Interview".
// Pattern: Two Pointers.
// Problem: Remove Duplicates (easy)
//
// Given an array of sorted numbers, remove all duplicates from it. 
// You should not use any extra space; after removing the duplicates in-place 
// return the length of the subarray that has no duplicate in it.

// This solution differs from the one presented in the course, but I like it better.
// Both have the same time / space complexity.

// Time: O(n)
// Space: O(1)
public static int remove(int[] arr) {
    int resultLength = arr.length;
    
    for (int leftPointer = 0; leftPointer < arr.length;) {
        int rightPointer = leftPointer + 1;

        while (rightPointer < arr.length && arr[leftPointer] == arr[rightPointer]) {
            arr[rightPointer] = 0;
            rightPointer++;
            resultLength--;
        }

        leftPointer = rightPointer;
    }

    return resultLength;
}
