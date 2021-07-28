# Big O - Logarithmic Time - O(log n))

## Definition

Logarithmic time is represented as O(log n) and describes algorithms which scale logarithmically with input. As their input size gets larger, the runtime increases but only at a logarithmic rate, which is much better than O(n).

For the purposes of Big O and Computer Science, we often assume base 2 and so we just write O(log n) instead of O(log2(n)).

Logarithmic runtime is often seen when things have a binary structure (things that get worked by powers of 2) and that get halved each run. Common examples would be: 
* Binary search
* Many types of binary tree traversals
