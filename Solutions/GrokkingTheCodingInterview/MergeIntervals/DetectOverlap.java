// From the educative.io course "Grokking the Coding Interview".
// Pattern: Merge Intervals
// Problem: Detect Overlap (medium)
//
// Given a set of intervals, find out if any two intervals overlap.
// This is listed as a similar problem on the MergeIntervals page.

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// Time: O(n logn)
// Even though we iterate the collection once, our sort operation takes O(n logn).
// 
// Space: O(n)
public static boolean hasOverlap(List<Interval> intervals) {

    // Check for null or less than 2.
    if (intervals == null || intervals.size() < 2) {
        return false;
    }

    // Sort the input.
    Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

    // Create an iterator.
    Iterator<Interval> i = intervals.iterator();

    // Set the first Interval and start and end.
    Interval interval = i.next();
    int start = interval.start;
    int end = interval.end;

    // While iterator.hasNext()
    while (i.hasNext()) {
        // Grab the next Interval.
        interval = i.next();

        // Check for overlap.
        if (interval.start <= end) {
            return true;
        } else { // Reset interval.
            start = interval.start;
            end = interval.end;
        }
    }

    return false;
}