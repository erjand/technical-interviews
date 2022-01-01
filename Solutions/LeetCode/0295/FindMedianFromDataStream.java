// LeetCode #295
// https://leetcode.com/problems/find-median-from-data-stream/
//
// The median is the middle value in an ordered integer list. 
// If the size of the list is even, there is no middle value and the median is the mean of the two middle values.
//
//  For example, for arr = [2,3,4], the median is 3.
//  For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
//
// Implement the MedianFinder class:
//
//  MedianFinder() initializes the MedianFinder object.
//  void addNum(int num) adds the integer num from the data stream to the data structure.
//  double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */