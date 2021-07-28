# Big O

## Overview

* Big O is the language and metric we use to describe the efficiency of algorithms with respect to time and space.
* Big O is fundamentally a measurement of how an algorithm scales with input (this allows us to do things like drop constants and non-dominant terms). We care about whether an algorithm scales linearly but not about whether it scales at .5N, N, 2N, etc.
* Be prepared to provide the time and space complexity for any algorithm you write.
* Once familiar with Big O, you should be able to quickly recognize common patterns and run-times.
* Big O helps us answer the question, "How can we do better?"
* Being familiar with Big O helps you quickly identify the Best-Case Runtime for many problems as well as what data structures are well suited to solving the problem vs those that can be discarded.

## Space Complexity

* In general, time complexity is more important than space complexity.
  * This is a generalization and depends on the problem context, but in most situations the CPU does the heavy lifting and running processor cycles is more expensive than RAM.
* Answers the question "how much more memory (RAM) do we need as the inputs get larger?"
* Space complexity increases with anything that allocates memory (assigning variables, creating new data structures, adding functions to the call stack, etc.).
* For many languages, primitives like bool and int are O(1) while things like strings, arrays and Objects are O(n).
* This probably corresponds to Stack (static allocated blocks of memory are constant) and Heap (dynamic in size and not allocated ahead of time) in most cases.

## Misc Rules

* It can be helpful to understand the difference between best, worst, and average case run-times but in general when describing algorithms we use worst-case (we can't make assumptions unless explicitly stated about the quality or shape of the data provided to our function).
  * One exception to generally using the worst-case is when *amortized runtime* makes more sense.
  * Example: adding an item to a List is almost always an O(1) operation unless that addition would exceed the amount of memory allocated to the List, in which case it will double it's size and copy itself which is an O(n) operation. So even though the worst-case of adding an item to a List is O(n) we still talk about it as O(1) since that is what we expect to happen in almost every case.
* Different steps get added together. Ex: O(a) + O(b) = O(a + b)
* Drop constants (we care about scaling not precision). Ex: O(2n) = O(n)
* Use different variables for your inputs as appropriate. Ex: O(n + m), O(k), etc.
* Drop non-dominant terms. Ex: O(n + n^2) = O(n^2)

## Resources

* [Big-O Cheat Sheet](https://www.bigocheatsheet.com/)
* [.NET Big-O Algorithm Complexities](https://rawgit.com/rehansaeed/.NET-Big-O-Algorithm-Complexity-Cheat-Sheet/main/Cheat%20Sheet.html)
* [What is Big O Notation](https://jarednielsen.com/big-o-notation/)
