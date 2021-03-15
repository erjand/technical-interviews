// LeetCode #7
// https://leetcode.com/problems/reverse-integer/
//
// Given a signed 32-bit integer x, return x with its digits reversed. 
// If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
// Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

// We use a combination of modulo with division and a queue to get all the digits and then reverse them.
// Since the problem specifies we can't a long, the C# checked() method allows us to detect an OverflowException. 
// If this library method wasn't available you could check for an overflow manually by examining the tail of the new number.

// Time: O(x) where x is the number of digits of x
// Space: O(x)
public class Solution {
    public int Reverse(int x) {
        bool isNegative = x < 0;
        if (isNegative) {
            x = x * -1;
        }
        Queue<int> queue = new Queue<int>();
        while (x >= 1) {
            queue.Enqueue(x % 10);
            x = x / 10;
        }
        
        int sum = 0;
        while (queue.Count != 0) {
            try {
                sum = checked(sum * 10);
            } catch (OverflowException) {
                return 0;
            }
            sum += queue.Dequeue();
        }
        
        if (isNegative) {
            sum = sum * -1;
        }
        return sum;
    }
}