// LeetCode #58
// https://leetcode.com/problems/length-of-last-word/
//
// Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
// A word is a maximal substring consisting of non-space characters only.

// The only slightly tricky thing in this problem is handling a few edge cases.

// Time: O(s)
// Space: O(s)
public class Solution {
    public int LengthOfLastWord(string s) {
        string[] words = s.Split(' ', StringSplitOptions.RemoveEmptyEntries);
        
        if (words.Length == 0) {
            return 0;
        }
        return words[words.Length - 1].Length;
    }
}