// LeetCode #575
// https://leetcode.com/problems/distribute-candies/
//
// Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.
// The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). 
// Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
// Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

// Time: O(n)
// Space: O(n)
public class Solution {
    public int DistributeCandies(int[] candyType) {
        int numberEaten = 0;
        int maxCanEat = candyType.Length / 2;
        HashSet<int> typesEaten = new HashSet<int>();
        
        for (int i = 0; i < candyType.Length; i++) {
            if (numberEaten < maxCanEat) {
                if (!typesEaten.Contains(candyType[i])) {
                    typesEaten.Add(candyType[i]);
                    numberEaten++;
                }
            }
        }
        
        return typesEaten.Count;
    }
}