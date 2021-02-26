// LeetCode #121
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// The brute force solution uses two for loops and runs in O(n^2).
// A better solution just uses one for loop, but keeps track of it's current min and max while it goes.
// Because we are dealing with an array that represents time, we only care about values moving forward so we don't need to compare back
// any current values to previous values in the array.
// This allows us to just adjust our maxProfit and minimum values with respect to each new value in the array.

// Time: O(n)
// Space: O(1)
public class Solution {
    public int MaxProfit(int[] prices) {
        if (prices == null || prices.Length == 0) return 0;
        
        int maxProfit = 0;
        int minimum = prices[0];
        
        for (int i = 0; i < prices.Length; i++) {
            if (prices[i] > minimum) {
                int salePrice = prices[i] - minimum;
                if (salePrice > maxProfit) {
                    maxProfit = salePrice;
                }
            } else {
                minimum = prices[i];
            }
        }
        
        return maxProfit;
    }
}