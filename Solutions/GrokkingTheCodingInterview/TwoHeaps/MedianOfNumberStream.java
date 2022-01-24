// From the educative.io course "Grokking the Coding Interview".
// Pattern: Two Heaps
// Problem: Find the Median of a Number Stream (medium)
// Related LeetCode Problem: https://leetcode.com/problems/find-median-from-data-stream/

// Problem Statement:
// Design a class to calculate the median of a number stream. The class should have the following two methods:
//
//  insertNum(int num): stores the number in the class
//  findMedian(): returns the median of all numbers inserted in the class
//
// If the count of numbers inserted in the class is even, the median will be the average of the middle two numbers.

class MedianOfAStream {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    // Time: O(logn) due to the heap insertion algorithm.
    // Space: O(n)
    public void insertNum(int num) {
        // Place num in either the minHeap or maxHeap.
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(num);
        } else if (num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        // Rebalance the two heaps if needed.
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.add(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    // Time: O(1)
    // Space: O(1)
    // Return either the average of min and max or the top of max.
    public double findMedian() {
        if (minHeap.size() == 0) {
            return maxHeap.peek();
        }
        
        int max = maxHeap.peek();
        int min = minHeap.peek();

        if (maxHeap.size() == minHeap.size()) {
            return (max / 2.0) + (min / 2.0);
        } else {
            return maxHeap.peek();
        }
    }
}