// From the educative.io course "Grokking the Coding Interview".
// Pattern: Cyclic Sort
// Problem: Find the Missing Number (easy)
//
// We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. 
// Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

// A very straight-forward way to solve this problem is with Arrays.sort.
// This approach increases the time complexity and uses extra space.
// Time: O(n logn)
// Space: O(n)
public static int findMissingNumber(int[] nums) {
    // Input validation.
    if (nums == null) {
        return -1;
    }

    // Sort the array. This is an O(n logn) operation.
    Arrays.sort(nums);

    // Traverse the array.
    for (int i = 0; i < nums.length; i++) {
        if (i != nums[i]) {
            return i;
        }
    }

    return -1;
}

// This solution has a lower time complexity, but still incurs extra space cost.
// Time: O(n)
// Space: O(n)
public static int findMissingNumber(int[] nums) {
    // Input validation.
    if (nums == null) {
        return -1;
    }

    // Create a second array and populate it with -1, making sure to increase the length by 1.
    int[] newArray = new int[nums.length + 1];
    Arrays.fill(newArray, -1);

    // Traverse our input array and assign the value at each index to that index in newArray.
    for (int i = 0; i < nums.length; i++) {
        newArray[nums[i]] = nums[i];
    }

    // Traverse newArray to find the missing number.
    for (int i = 0; i < newArray.length; i++) {
        if (newArray[i] == -1) {
            return i;
        }
    }

    return -1;
}

// The most optimal solution involves using a swap method and sorting the array in place, then finding the missing number.
// Time: O(n)
// Space: O(1)
public static int findMissingNumber(int[] nums) {
    // Input validation.
    if (nums == null) {
        return -1;
    }

    // Perform the cyclic sort with swapping.
    int i = 0;
    while (i < nums.length) {
        if (nums[i] < nums.length && nums[i] != i) {
            int temp = nums[nums[i]];
            nums[nums[i]] = nums[i];
            nums[i] = temp;
        } else {
            i++;
        }
    }

    // Traverse the sorted array and find the missing number.
    for (i = 0; i < nums.length; i++) {
        if (nums[i] != i) {
            return i;
        }
    }

    return -1;
}