/*
Tags: #array

Problem Source:
From the educative.io course "Ace the Java Coding Interview"

Problem Statement:
Implement a method which will take a number n, and an array arr as input and returns an array of two integers 
that add up to n in an array. If no pair is found then return the array.
*/

// Time: O(n)
// Space: O(n)
public static int[] findSum(int[] arr, int n) {
    HashSet<Integer> numHash = new HashSet<Integer>();

    for (int i : arr) {
        int complement = n - i;

        if (numHash.contains(complement)) {
            return new int[] {i, complement};
        } else {
            numHash.add(i);
        }
    }

    return arr;
}