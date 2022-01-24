// LeetCode #121
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

// Time: O(n)
// Space: O(1)
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int low = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < low) {
                low = prices[i - 1];
            }
            
            int saleOption = prices[i] - low;
            
            if (saleOption > profit) {
                profit = saleOption;
            }
        }
        
        return profit;
    }
}