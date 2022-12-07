// From the educative.io course "Grokking the Coding Interview".
// Pattern: Sliding Window.
//
// Given an array of positive numbers and a positive number ‘S,’ 
// find the length of the smallest contiguous subarray 
// whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.

// Time: O(n)
// Space: O(1)
public static int findMinSubArray(int S, int[] arr) {
    int smallestLength = Integer.MAX_VALUE;
    int windowLength = 0;
    int windowSum = 0;
    int windowStart = 0;

    for (windowEnd = 0; windowEnd < arr.length;) {
        // Expand the window until our sum >= S
        while (windowSum < S && windowEnd < arr.length) {
            windowSum += arr[windowEnd];
            windowLength++;
            windowEnd++
        }

        // If we never made it, return 0.
        if (windowSum < S) {
            return 0;
        }
      
        // Trim the window from the rear until we are smaller than S again.
        while (windowSum >= S && windowStart != windowEnd) {
            smallestLength = Math.min(smallestLength, windowLength);
            windowSum -= arr[windowStart];
            windowLength--;
            windowStart++;
        }
    }

    return smallestLength;
}