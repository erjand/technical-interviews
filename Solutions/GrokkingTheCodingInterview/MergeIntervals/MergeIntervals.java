// From the educative.io course "Grokking the Coding Interview".
// Pattern: Merge Intervals
// Problem: Merge Intervals (medium)
//
// Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive intervals.

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
public static List<Interval> mergeIntervals(List<Interval> intervals) {

    // No overlap.
    if (intervals.size() < 2) {
        return intervals;
    }

    // Sort the start times to ensure a.start <= b.start for all intervals.
    Collections.sort(intervals, Comparator.comparingInt(a -> a.start));

    List<Interval> result = new LinkedList<>();

    // Build an iterator to iterate our collection.
    Iterator<Interval> intervalIterator = intervals.iterator();
    Interval interval = intervalIterator.next();

    // Start with the first Interval.
    int start = interval.start;
    int end = interval.end;

    // Iterate the collection by checking for one or more elements still left.
    while (intervalIterator.hasNext()) {

        // Grab the next Interval.
        interval = intervalIterator.next();

        // Compare the first Interval to the next Interval (b.start <= a.end)
        if (interval.start <= end) {
            // If we found an overlap, set the new end with max(a.end, b.end)
            end = Math.max(end, interval.end);
        } else { // If we did not find an overlap we can safely add the Interval.
            // Add whatever our current start and end are.
            result.add(new Interval(start, end));

            // Reset start and end to the Interval we just completed.
            start = interval.start;
            end = interval.end;
        }
    }

    // Add the last interval once our collection has been fully iterated.
    result.add(new Interval(start, end));

    return result;
}
