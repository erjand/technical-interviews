/*
Tags: #array

Problem Source:
From the educative.io course "Ace the Java Coding Interview"

Problem Statement:
Write an algorithm to remove all even integers from an array, then return the new array.
*/

// Time: O(n)
// Space: O(n)
public static int[] removeEven(int[] arr) {
    // Iterate through the array one-time to find out how many odd integers there are.
    int oddCount = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 != 0) {
            oddCount++;
        }
    }

    // Instantiate the result array, and reset oddCount to 0.
    int[] result = new int[oddCount];
    oddCount = 0;

    // Iterate through the array a second time to populate the result array.
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] % 2 != 0) {
            result[oddCount] = arr[i];
            oddCount++;
        }
    }

    return result;
}