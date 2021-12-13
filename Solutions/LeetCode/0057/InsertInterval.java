// LeetCode #57
// https://leetcode.com/problems/insert-interval/
//
// You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] 
// represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. 
// You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
// Insert newInterval into intervals such that intervals is still sorted in ascending order 
// by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
//
// Return intervals after the insertion.

// Time: O(n)
// Space: O(n)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        // Perform input validation.
        if (intervals == null || intervals.length < 1) {
            return new int[][] {newInterval};
        }

        ArrayList<int[]> result = new ArrayList<>();
        int index = 0;

        // Add all Intervals to our list that occur before the newInterval.
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(new int[] { intervals[index][0], intervals[index][1] });
            index++;
        }

        // Continually merge intervals as needed where there is overlap with newInterval.
        while (index < intervals.length && intervals[index][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[index][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[index][1], newInterval[1]);
            index++;
        }

        // Add the merged interval.
        result.add(newInterval);

        // Add the remainder of the intervals.
        while (index < intervals.length) {
            result.add(new int[] { intervals[index][0], intervals[index][1] });
            index++;
        }

        return result.toArray(new int[result.size()][]);
    }
}