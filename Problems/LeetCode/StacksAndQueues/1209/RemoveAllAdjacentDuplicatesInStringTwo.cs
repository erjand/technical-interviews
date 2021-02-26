// LeetCode #1209
// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
//
// Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.
// We repeatedly make k duplicate removals on s until we no longer can.
// Return the final string after all such duplicate removals have been made.
// It is guaranteed that the answer is unique.

// This solution makes use of a helper class to store a char and its count. By creating a stack of this Adjacent class object,
// we can iterate through our string just one time but remove all of the characters whenever they hit the threshold of k.
// Once we are done, whatever is left on the stack will be our new string, so we use StringBuilder to build it out, and then
// make use of the Array.Reverse library function to put the string back into the correct order.

// Time: O(s)
// Space: O(s)
public class Solution {
    public string RemoveDuplicates(string s, int k) {
        Stack<Adjacent> stack = new Stack<Adjacent>();
        
        foreach (char c in s) {
            if (stack.Count > 0 && stack.Peek().c == c) {
                stack.Peek().count++;
            } else {
                stack.Push(new Adjacent(c, 1));
            }
            if (stack.Count > 0 && stack.Peek().count >= k) {
                stack.Pop();
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (stack.Count != 0) {
            Adjacent adj = stack.Pop();
            for (int i = 0; i < adj.count; i++) {
                sb.Append(adj.c);
            }
        }
        
        string result = sb.ToString();
        char[] res = result.ToCharArray();
        Array.Reverse(res);
        return new string(res);
    }
}

public class Adjacent {
    public char c;
    public int count;

    public Adjacent(char c, int count) {
        this.c = c;
        this.count = count;
    }
}