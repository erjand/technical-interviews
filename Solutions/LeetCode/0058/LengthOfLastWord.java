// LeetCode #58
// https://leetcode.com/problems/length-of-last-word/
//
// Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the last word does not exist, return 0.
// A word is a maximal substring consisting of non-space characters only.

// One way to solve this problem is to use some of the built-in String functions in Java .trim() and .split()
// Time: O(n)
// Space: O(n)
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] split = s.split(" ");

        if (split.length == 0) {
            return 0;
        } else {
            return split[split.length - 1].length();
        }
    }
}

// The other option without using String library functions is to reverse the string and look for the
// occurrence of the first space after the beginning of a word has been found.
// Time: O(n)
// Space: O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else {
                if (length > 0) {
                    return length;
                }
            }
        }
        
        return length;
    }
}