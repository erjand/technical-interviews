// From the educative.io course "Grokking the Coding Interview".
// Pattern: Fast and Slow Pointers.
// Problem: Happy Number (medium).
//
// Any number will be called a happy number if, after repeatedly replacing it with a 
// number equal to the sum of the square of all of its digits, leads us to number ‘1’. 
//
// All other (not-happy) numbers will never reach ‘1’. 
// Instead, they will be stuck in a cycle of numbers which does not include ‘1’.

// This solution does not use the fast and slow pointers, but rather a HashSet
// to track previously seen solutions. It works well, but does use extra memory.
// Time: O(logn)
// Space: O(logn)
public static boolean find(int num) {
    
    HashSet<Integer> prev = new HashSet<>();

    while (num != 1) {
        int tempSum = 0;
        
        while (num >= 1) {
            int digit = num % 10;
            tempSum += digit * digit;
            num = num / 10;
        }

        num = tempSum;
        if (prev.contains(num)) {
            return false;
        } else {
            prev.add(num);
        }
    }

    return true;
}

// This solution is implemented using the fast and slow pointer pattern and does
// not require an additional data structure to track previous sums.
// Time: O(logn)
// Space: O(1)
public static boolean find(int num) {
    int fast = num;
    int slow = num;

    // Still finding the cycle.
    do {
        slow = sumSquaredDigits(slow);
        fast = sumSquaredDigits(sumSquaredDigits(fast));
    } while (slow != fast);

    // Cycle has been found - is it at 1 or something else?
    return slow == 1;
}

// Helper method for summing up our squared digits.
public static int sumSquaredDigits(int num) {
    int sum = 0;
    
    while (num > 0) {
        int digit = num % 10;
        sum += digit * digit;
        num /= 10;
    }

    return sum;
}