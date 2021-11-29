// LeetCode #1165
// https://leetcode.com/problems/single-row-keyboard/
//
// There is a special keyboard with all keys in a single row.
// Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. 
// To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
// You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.

// The O(1) space solution for this problem uses an int[26] array to map the letters to their index instead of a dictionary.
// It is more optimal but to me feels a bit like a non-intuitive trick that you wouldn't really want to see in real code.

// Time: O(n)
// Space: O(n) - could be improved to O(1) by using an array instead of a dictionary
public class Solution {
    public int CalculateTime(string keyboard, string word) {
        Dictionary<char, int> keyboardDict = new Dictionary<char, int>();
        
        for (int i = 0; i < keyboard.Length; i++) {
            keyboardDict.Add(keyboard[i], i);
        }
        
        int time = 0;
        int previousIndex = 0;
        
        for (int i = 0; i < word.Length; i++) {
            int currentIndex = keyboardDict[word[i]];
            time += Math.Abs(currentIndex - previousIndex);
            previousIndex = currentIndex;
        }
        
        return time;
    }
}