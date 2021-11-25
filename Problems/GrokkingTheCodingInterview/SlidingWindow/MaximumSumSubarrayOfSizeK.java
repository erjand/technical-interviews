// From the educative.io course "Grokking the Coding Interview".
// Pattern: Sliding Window.

// Time: O(n)
// Space: O(1)
public static int findMaxSumSubArray(int k, int[] arr) {
    int maxSum = 0;
    int windowSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd];
        
        if (windowEnd >= k - 1) {
            maxSum = Math.max(windowSum, maxSum);
            windowSum -= arr[windowStart];
            windowStart++;
        }
    }

    return maxSum;
}