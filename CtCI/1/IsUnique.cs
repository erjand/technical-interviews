// CtCI 1.1
// Question: Implement an algorithm to determine if a string has all unique characters. 
// Can you do it in constant time?

// Time: O(s)
// Space: O(s)
// A very straight-forward solution that uses additional memory.
public bool IsUnique(string s) {
    HashSet<char> charSet = new HashSet<char>();
    foreach (char c in s) {
        if (charSet.Contains(c)) {
            return false;
        }
        charSet.Add(c);
    }

    return true;
}

// Time: O(s)
// Space: O(1)
// We can solve the problem in constant time if we make assumptions about the encoding.
// Ex: ASCII has no more than 128 unique characters
public bool IsUnique(string s) {
    if (s.Length > 128) return false;
    bool[] hasChar = new bool[128];

    foreach (char c in s) {
        if (hasChar[c]) return false;
        hasChar[c] = true;
    }

    return true;
}