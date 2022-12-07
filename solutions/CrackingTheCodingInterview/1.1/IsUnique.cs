/*
Tags: #array

Problem Source:
From Cracking the Coding Interview, problem 1.1

Problem Statement:
Implement an algorithm to determine if a string has all unique characters. Can you do it in constant time?
*/

public class Solution {
    // Time: O(n)
    // Space: O(n)
    // A very straight-forward solution that uses additional memory.
    public bool IsUnique(string s) {
        HashSet<char> charSet = new HashSet<char>();
        foreach (char c in s) {
            if (charSet.Contains(c)) {
                return false;
            }
            charSet.Add(c);
        }

        return true;
    }

    // Time: O(n)
    // Space: O(1)
    // We can solve the problem in constant time if we make assumptions about the encoding.
    // Ex: ASCII has no more than 128 unique characters
    public bool IsUnique(string s) {
        if (s.Length > 128) return false;
        bool[] hasChar = new bool[128];

        foreach (char c in s) {
            if (hasChar[c]) return false;
            hasChar[c] = true;
        }

        return true;
    }
}