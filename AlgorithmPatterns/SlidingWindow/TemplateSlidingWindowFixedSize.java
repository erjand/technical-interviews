// A template for implementing the Sliding Window algorithm pattern
// with a fixed-length window.

public static int slidingWindowFixed(int windowSize, int[] arr) {
    int windowStart = 0;

    // Traverse the array once.
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {

        // Perform the window-end operation until greater than the fixed window size.
        
        // Shrink the window by 1 back to the fixed size.
        if (windowEnd >= windowSize - 1) {
            
            // Perform the window-start operation.
            
            windowStart++;
        }
    }

    return -1;
}
