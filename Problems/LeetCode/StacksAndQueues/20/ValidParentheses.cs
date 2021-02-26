// LeetCode #20
// https://leetcode.com/problems/valid-parentheses/
//
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.

// This problem is solved by using a stack, where we push any opening braces onto the stack but for any closing braces we peek 
// the stack to see if it's match is on top. We don't need to ever push the closing braces onto the stack, just check each one for it's
// partner and pop / push the opening braces as they are encountered.
// You can also do some early checking by ruling out any odd numbered strings.

// Time: O(n)
// Space: O(n)
public class Solution {
    public bool IsValid(string s) {
        // Examples
        // (())
        // {[({()})]}
        // {}()[]
        
        if (s == null) return false;
        if (s.Length == 0 || s.Length == 1) return false;
        if (s.Length % 2 != 0) return false;
        
        Stack<char> stack = new Stack<char>();
        
        for (int i = 0; i < s.Length; i++) {
            char c = s[i];
            if (c == '{' || c == '[' || c == '(') {
                stack.Push(c);
            }
            
            if (c == '}') {
                if (stack.Count == 0 || stack.Peek() != '{') {
                    return false;
                }
                stack.Pop();
            }
            
            if (c == ']') {
                if (stack.Count == 0 || stack.Peek() != '[') {
                    return false;
                }
                stack.Pop();
            }
            
            if (c == ')') {
                if (stack.Count == 0 || stack.Peek() != '(') {
                    return false;
                }
                stack.Pop();
            }
        }
        
        if (stack.Count != 0) return false;
        
        return true;
    }
}