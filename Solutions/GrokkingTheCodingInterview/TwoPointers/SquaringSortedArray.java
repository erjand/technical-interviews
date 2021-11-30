// From the educative.io course "Grokking the Coding Interview".
// Pattern: Two Pointers.
// Problem: Squaring a Sorted Array (easy)
//
// Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

// Time: O(n)
// Space: O(n)
public static int[] makeSquares(int[] arr) {
    int[] squares = new int[arr.length];
    int left = 0;
    int right = arr.length - 1;
    int squarePointer = squares.length - 1;

    while (left < right) {        
        if (Math.abs(arr[left]) > Math.abs(arr[right])) {
            squares[squarePointer] = arr[left] * arr[left];
            left++;
        } else {
            squares[squarePointer] = arr[right] * arr[right];
            right--;
        }
        squarePointer--;
    }

    return squares;
}
