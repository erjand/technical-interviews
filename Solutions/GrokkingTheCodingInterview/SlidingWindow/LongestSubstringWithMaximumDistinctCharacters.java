// From the educative.io course "Grokking the Coding Interview".
// Pattern: Sliding Window.
//
// Given a string, find the length of the longest substring in it with no more than K distinct characters.

// Time: O(n)
// Space: O(1)
public static int findLength(String str, int k) {
    HashSet<Character> charSet = new HashSet<>();
    int longestLength = Integer.MIN_VALUE;
    int windowStart = 0;
    
    for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
        // Expand the window until we have more than K distinct chars.
        char endChar = str.charAt(windowEnd);
        if (!charSet.contains(endChar)) {
            charSet.add(endChar);
        }

        // Contract the window while we have more than K distinct chars.
        while (charSet.size() > k) {
            char startChar = str.charAt(windowStart);
            if (charSet.contains(startChar)) {
                charSet.remove(startChar);
            }
            charSet.remove(str.charAt(windowStart));
            windowStart++;
        }

        // Update our longest window length on each loop.
        longestLength = Math.max(longestLength, windowEnd - windowStart + 1);
    }

    return longestLength;
}
