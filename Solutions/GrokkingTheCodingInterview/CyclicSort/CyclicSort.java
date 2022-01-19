/*
Tags: #array, #sort

Problem Source:
From the educative.io course "Grokking the Coding Interview".
Pattern: Cyclic Sort
Problem: Cyclic Sort (easy)

Problem Statement:
We are given an array containing n objects. 
Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence.
This means that the object with sequence number 3 was created just before the object with sequence number 4.
Write a function to sort the objects in-place on their creation sequence number in O(n) 
and without using any extra space. 

For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, 
though each number is actually an object.

Solution Notes:
The trick to this problem is to only increment i when a swap does not occur,
otherwise you can move past elements that are still in an incorrect position.
*/

// Time: O(n)
// Space: O(1)
public static void sort(int[] nums) {
    int i = 0;
    while (i < nums.length) {
        int j = nums[i] - 1;

        if (nums[i] != nums[j]) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        } else {
            i++;
        }
    }
}