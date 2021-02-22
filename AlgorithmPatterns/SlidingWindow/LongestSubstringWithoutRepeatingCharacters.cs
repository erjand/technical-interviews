// LeetCode #3
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
//
// Given a string s, find the length of the longest substring without repeating characters.

// This is an example implementation of the "sliding window" pattern and a very common problem.

// Time: O(n)
// Space: O(1)
public class Solution {
    public int LengthOfLongestSubstring(string s) {
        if (s == null || s.Length == 0) return 0;
        
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<char> charSet = new HashSet<char>();
        
        while (i < s.Length) {
            while (charSet.Contains(s[i])) {
                charSet.Remove(s[j]);
                j++;
            }
            charSet.Add(s[i]);
            max = Math.Max(max, i - j + 1);
            i++;
        }
        
        return max;
    }
}