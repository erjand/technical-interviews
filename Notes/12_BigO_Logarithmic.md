# Big O - Logarithmic Time - O(log n))

## Definition

Logarithmic time is represented as O(log n) and describes algorithms which scale logarithmically with input. As their input size gets larger, the runtime increases but only at a logarithmic rate, which is much better than O(n).

For the purposes of Big O and CS, the base 2 is assumed and so we just write O(log n) instead of O(log2(n)).

Logarithmic runtime is seen often where things have a binary structure (things that get worked by powers of 2) and that get halved each run. Common examples would be: binary search, or many types of binary tree traversals.
