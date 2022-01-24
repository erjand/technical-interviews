// From the educative.io course "Grokking the Coding Interview".
// Pattern: Sliding Window.
//
// Given an array of characters where each character represents a fruit tree, 
// you are given two baskets, and your goal is to put maximum number of fruits in each basket. 
// The only restriction is that each basket can have only one type of fruit.
//
// You can start with any tree, but you can’t skip a tree once you have started. 
// You will pick one fruit from each tree until you cannot, i.e., 
// you will stop when you have to pick from a third fruit type.
//
// Write a function to return the maximum number of fruits in both baskets.

// This problem is really just asking:
// "what is the maximum sized subarray with no more than two distinct characters?"

// Time: O(n)
// Space: O(1)
public static int findLength(char[] arr) {
    // Setup our data structures and variables.
    HashMap<Character, Integer> charMap = new HashMap<>();
    int longestWindow = 0;
    int currentWindow = 0;
    int windowStart = 0;

    // Loop once through the array.
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        
        // Perform the window-end operation.
        char endChar = arr[windowEnd];
        if (!charMap.containsKey(endChar)) {
            charMap.put(endChar, 1);
        } else {
            charMap.put(endChar, charMap.get(endChar) + 1);
        }

        // Perform the window-start operation until back in alignment.
        while (charMap.size() > 2) {
            
            // Perform the window-start operation.
            char startChar = arr[windowStart];
            if (charMap.get(startChar) > 1) {
                charMap.put(startChar, charMap.get(startChar) - 1);
            } else {
                charMap.remove(startChar);
            }

            windowStart++;
        }

        // Update our result.
        currentWindow = windowEnd - windowStart + 1;
        longestWindow = Math.max(longestWindow, currentWindow);
    }

    return longestWindow;
}
