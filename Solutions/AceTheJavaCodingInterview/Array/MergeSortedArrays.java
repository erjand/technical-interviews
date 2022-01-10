/*
Tags: #array

From the educative.io course "Ace the Java Coding Interview"

Problem Statement:
Given two sorted arrays, implement a method which returns a sorted array
consisting of all elements of both arrays.
*/

// Time: O(a1 + a2)
// Space: O(a1 + a2)
public static int[] mergeArrays(int[] arr1, int[] arr2) 
    {  
        int[] result = new int[arr1.length + arr2.length];
        int k = 0;

        for (int i = 0, j = 0; i < arr1.length || j < arr2.length; ) {
            if (i >= arr1.length) {
                result[k] = arr2[j];
                j++;
            } else if (j >= arr2.length) {
                result[k] = arr1[i];
                i++;
            } else if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
            } else if (arr2[j] < arr1[i]) {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
      
    return result;
} 