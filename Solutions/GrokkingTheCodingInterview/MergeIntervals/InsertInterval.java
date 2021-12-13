// From the educative.io course "Grokking the Coding Interview".
// Pattern: Merge Intervals
// Problem: Insert Interval (medium)
// Similar LeetCode Problem: https://leetcode.com/problems/insert-interval/
//
// Given a list of non-overlapping intervals sorted by their start time, 
// insert a given interval at the correct position 
// and merge all necessary intervals to produce a list that has only mutually exclusive intervals.

// This problem is very similar to https://leetcode.com/problems/insert-interval/, only it uses
// an Interval class vs a 2d-array.

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

// Time: O(n) - Because this list is sorted, we can do a single traversal.
// Space: O(n)
public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    // Input validation.
    if (intervals == null || intervals.size() < 1) {
        if (newInterval != null) {
            return new ArrayList<Interval>(Arrays.asList(newInterval));
        } else {
            return new ArrayList<Interval>();
        }
    }

    // Setup our return and index counter.
    List<Interval> mergedIntervals = new ArrayList<>();
    int i = 0;
    
    // Add the intervals where there is no overlap.
    while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
        mergedIntervals.add(intervals.get(i));
        i++;
    }

    Interval merged = new Interval(-1, -1);
    // Grow our merged interval so long as we have any overlap.
    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
        merged.start = Math.min(intervals.get(i).start, newInterval.start);
        merged.end = Math.max(intervals.get(i).end, newInterval.end);
        i++;
    }

    // Insert the merged interval.
    mergedIntervals.add(merged);

    // Add the rest that occur after the merge is done.
    while (i < intervals.size()) {
        mergedIntervals.add(intervals.get(i));
        i++;
    }

    return mergedIntervals;
}
