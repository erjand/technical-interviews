// LeetCode #383
// https://leetcode.com/problems/ransom-note/
//
// Given an arbitrary ransom note string and another string containing letters from all the magazines, 
// write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
// Each letter in the magazine string can only be used once in your ransom note.

// This problem can also be solved using an int[26] for each letter of the alphabet for O(1) space.

// Time: O(m)
// Space: O(m)
public class Solution {
    public bool CanConstruct(string ransomNote, string magazine) {
        Dictionary<char, int> magazineDict = new Dictionary<char, int>();
        
        foreach (char c in magazine) {
            if (magazineDict.ContainsKey(c)) {
                magazineDict[c]++;
            } else {
                magazineDict.Add(c, 1);
            }
        }
        
        foreach (char c in ransomNote) {
            if (!magazineDict.ContainsKey(c)) {
                return false;
            } else {
                if (magazineDict[c] == 1) {
                    magazineDict.Remove(c);
                } else {
                    magazineDict[c]--;
                }
            }
        }
        
        return true;
    }
}