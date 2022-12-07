// From the educative.io course "Grokking the Coding Interview".
// Pattern: Subsets
// Problem: Subsets (easy)
// Related LeetCode Problem: https://leetcode.com/problems/subsets/

// Problem Statement:
// Given a set with distinct elements, find all of its distinct subsets.

// Solution Description:
// This is an implementation of a BFS algorithm on a linear data structure vs a tree.
// The number of subsets doubles for each additional n, which is 2^n.
// Because we are creating new sets on each iteration of n, the time complexity is O(n * 2^n)
// The space complexity is the same, since we will have 2^n subsets, each of which can take up to n space.

// Time: O(n * 2^n)
// Space: O(n * 2^n) 
public static List<List<Integer>> findSubsets(int[] nums) {    
    List<List<Integer>> subsets = new ArrayList<>();
    subsets.add(new ArrayList<>());

    // Input validation.
    if (nums == null || nums.length == 0) {
        return subsets;
    }    

    // Iterate through all of nums.
    for (int currentNumber : nums) {
        
        // For each previously existing subset...
        int subSetCount = subsets.size();
        for (int i = 0; i < subSetCount; i++) {
            
            // ...make a copy, add the currentNumber, and then add the new set to subsets.
            List<Integer> newSet = new ArrayList<>(subsets.get(i));
            newSet.add(currentNumber);
            subsets.add(newSet);
        }
    }

    return subsets;
}