# Study Notes

This document is a high-level overview and roadmap to prepare for technical interviews. It does not address System Design preparation or topics.

Overall, I have tried to keep the document short by providing information about the things to study rather than the study material itself. The [Resources](#resources) section at the end of the document is an attempt at curating a list of quality resources for additional study.

Some portions are still WIP.

## Table of Contents

1. [Getting Started](#getting-started)
2. [How to Interview](#how-to-interview)
3. [Big O](#big-o)
4. [Data Structures](#data-structures)
5. [Algorithms](#algorithms)
6. [Resources](#resources)

## Getting Started

> "What any person in the world can learn, _almost_ all persons can learn, _if_ provided with the appropriate prior and current conditions of learning." - Dr. Carol Dweck, from the book _Mindset_

1. **Set a specific goal:** "I want to work at company X, or a company like X, by date Y". This can change over time, but it is helpful to be targeted and measured in your time usage as you begin.

2. **Build a roadmap to get from where you are now to where you want to be.** Depending on your level of familiarity with some of these topics, this roadmap could be as detailed as working through a long list of data structures and algorithms, or as pointed as doing a couple of practice interviews and reviewing key concepts.

3. **Pick a specific programming language to use for your preparation.** When you go to interview, you will be asked what language you want to use. You want to be very comfortable with the syntax and data structures available to you in your chosen language, as well as understanding other important languages features. It is recommended to pick a language that is widely-used and has some basic library support for common data structures. Some good choices are:
   - Java (if unsure, pick this or Python)
   - Python
   - C# (this can be a good choice over Java if you are targeting companies in the Windows ecosystem)
   - C++ (particularly if interested in companies that favor lower-level languages)
   - JavaScript (particularly if interested in front-end roles)
   - Other languages that could make sense given your particular goals: Go, Kotlin, Rust, Ruby, Swift, etc.

4. **Work with others**. Having other experienced engineers that you can ask questions of, practice with, or discuss concepts with is very helpful and can save a lot of time trying to learn new things or discover your unknown-unknowns. Ideally these would be real-world connections, but in the absence of these kinds of relationships, there are a number of online communities where you can participate and discuss with others.

5. **Be intentional and strategic in your preparation**. This is a broad topic, but here are a few suggestions:
   - There are an almost limitless number of technical resources online of varying degrees of quality. Rather than trying to gain a comprehensive breadth of knowledge on all subjects, take the time to identify the ideas that are truly important to master and focus on utilizing high-quality resources in those areas.
   - Don't try to memorize things. Instead, look for and learn patterns and concepts.
   - Data Structures are usually more important than Algorithms. Understanding how data structures work, how they are implemented in your chosen language, and when they are used will allow you to determine the appropriate data structure for the appropriate problem. Once the correct data structure is in place, the necessary algorithm will often be readily apparent.
   - Try to study and practice for shorter lengths of time regularly instead of longer lengths of time irregularly.

6. **Setup your environment and tools**. You will want to ensure you have the following:
   - A text editor with syntax support for your chosen programming language.
      - [Visual Studio Code](https://code.visualstudio.com/) is a popular and strong choice.
      - You will be using your text editor for most of your practice problems. In an actual interview, it is unlikely you will use an actual IDE. A text editor with syntax highlighting but without auto-completion and some of the built-in features of a full IDE is a close simulation for real-world interviews.
      - In the past it may have been suggested to do coding problems with pencil and paper to more closely simulate white-boarding interviews, but in the post-COVID world of remote interviews, you will likely be doing all of your interviewing in an environment such as [CoderPad](https://coderpad.io/).
   - A note-taking system and appropriate tools.
      - If you don't already have a good system in place for taking notes, this could be an opportunity to begin developing one.
      - Writing things down is an important part of the learning process, and as you study and take notes you will quickly end up with a helpful collection of resources to review or share with others.
      - I like [Obsidian](https://obsidian.md/), but finding something that works well for you can be a personal choice.
   - (Recommended) An IDE or the ability to compile / interpret code.
      - You do not want to do your regular practice with an IDE, but it can be helpful to do things like run unit tests, print statements, or debug code as needed.
      - My recommendation is to have a stubbed out unit test or runnable file where you can quickly paste your code and then see what it does. This is helpful when you are struggling to see how a solution works, or want to step line by line through an algorithm.
      - If you are using an interpreted language such as Python, then Visual Studio Code will have excellent extensions available to you for running code in the text editor itself. If you are using Java, [IntelliJ IDEA Community](https://www.jetbrains.com/idea/download) is a great place to start. If you are using C#, then [Visual Studio Community](https://visualstudio.microsoft.com/vs/community/) is a high-quality and free option.
   - (Optional) Some people find spaced-repetition flash card programs, such as [Anki](https://ankiweb.net/about) to be very useful.

## How to Interview

TODO: Write this section.

## Big O

Big O is the language and metric used to describe the efficiency of algorithms with respect to time and space. Big O is fundamentally a measurement of how an algorithm scales with input.

The goals for this section are to be able to:

- [ ] Understand the major Big O complexities and their relationship to each other (small to large).
- [ ] Identify the Big O time and space complexity for any algorithm you write.
- [ ] Be familiar with the Big O time and space complexity for common algorithms and data structures (e.g. most sorting algorithms are `O(n logn)`).

### Key Rules

- Because Big O is a measurement of how an algorithm scales, we can drop constants and non-dominant terms. We care about whether an algorithm scales linearly, for example, and not about whether it scales at 0.5n, 1n, 2n, etc.
  - Example: `O(2n)` becomes `O(n)` because `2n` is still just linear.
  - Example: `O(n + n^2)` becomes `O(n^2)` because the constant `n` is not important compared to the quadratic `n^2`.
- Add different steps together (e.g. `O(a) + O(b)` = `O(a + b)`).
- Use different variables as appropriate to represent your inputs (e.g. `O(n + m)`, or `O(k)`, or `O(a1 + a2)`, etc.).

### Space Complexity

- In general, time complexity is more important than space complexity. This is a generalization and depends on the problem context, but in most situations the CPU does the heavy lifting. Running processor cycles is more expensive than RAM.
- Space complexity answers the question "how much more memory (RAM) do we need as the inputs get larger?"
- Space complexity increases with anything that allocates memory (assigning variables, creating new data objects, adding functions to the call stack, etc.).
- For many languages, primitives like `bool` and `int` add `O(1)` space while things like strings, arrays and Objects add `O(n)`.
- A common task for space complexity will be to take an operation that requires `O(n)` space and do it with `O(1)` space instead. An example of this is being asked to sort a data structure in place instead of copying it to a new one.

### Amortized Runtime

Amortized runtime is a way of describing the runtime where the worst case happens but then doesn't happen again for a while.

Example: adding an item to a `List` is almost always an `O(1)` operation unless that addition would exceed the amount of memory allocated. If this is the case, the List will double it's size and copy itself, which is an `O(n)` operation. Even though the worst-case of adding an item to a List is `O(n)` we still talk about it as `O(1)` since that is what we expect to happen in _almost_ every case.

### Syntax and Base 2

When writing down runtimes, two important rules are generally observed in a non-academic setting.

1. Base 2 is assumed, so you can simply write `log n`, which is understood to be `log base 2 of n`. You will see this written as both `log n` and `logn`.
2. The multiplication symbol is dropped, so you can write `n logn`, which is understood to be `n * logn`.

### Important Complexities

The following are important complexities to be familiar with (sorted smallest to largest).

- Constant `O(1)`
- Logarithmic `O(log n)`
- Linear `O(n)`
- Multilinear `O(m + n)`
- Linear Logarithmic `O(n logn)`
- Quadratic `O(n^2)`
- Cubic `O(n^3)`
- Exponential `O(2^n)`
- Factorial `O(n!)`

TODO: Add a brief description and sample algorithm for each complexity.

## Data Structures

> "Data dominates. If you've chosen the right data structures and organized things well, the algorithms will almost always be self-evident. Data structures, not algorithms, are central to progamming." -Rob Pike, [5 Rules of Programming](http://users.ece.utexas.edu/~adnan/pike.html)

The goals for this section are to be able to:

- [ ] Identify and talk about each of the major data structures.
- [ ] Loosely implement each of the major data structures in your chosen language.
- [ ] Identify and explain the Big O time and space complexity for the important operations of each of the major data structures (access, search, insert, remove).
- [ ] Choose the correct data structure(s) to use for solving a given problem.
- [ ] Know what the significant methods and properties for each data structure are, and how to use them (e.g. that a `Queue` will have `.push()`, `.peek()`, and `.pop()`.

### Major Data Structures

The following are the most important data structures to be familiar with. Of these, particular attention should be given to HashTables and Arrays, as many problems are solved with these two structures alone.

- Array (single and multi-dimensional, especially two-dimensional)
- Resizable Array (List, ArrayList)
- String
- HashTable (both a hash of elements and a collection of hashed key-value pairs)
- LinkedList (single and double, though double is less common)
- Queue
- Stack
- Trees (some of the most important are: binary, sorted binary, n-ary, and prefix trees)
- Graphs

TODO: Break down each of these data structures with some brief explanation and enumerate the sub categories when helpful (e.g. trees).

## Algorithms

It is important that you are familiar with frequently used algorithm patterns and a standard assortment of common algorithms. Knowing these will allow you to solve problems quickly versus having to figure out algorithmic implementations for each problem as you go.

It is recommended that you focus on learning patterns and frequently used algorithms instead of trying to memorize specific solutions to specific problems.

The goals for this section are to be able to:

- [ ] Be familiar with a list of frequently used algorithm patterns and recognize when they are needed for a particular problem.
- [ ] Know how to quickly and cleanly implement various algorithmic tasks such as splitting an integer into its digits, performing a DFS or BFS tree search, etc.
- [ ] Know the common sorting and searching algorithms: their names, Big O complexities, and how to loosely implement a few of them.
- [ ] Be able to name the Big O time and space complexity for any algorithm you write.

### Important Algorithm Patterns

At the bottom of this page there are links to more information on important patterns. Each list of important patterns may have slight differences. In addition, the number and complexity of patterns you want to learn could vary based on how heavy the algorithm portion of the interview at your targeted companies will be. For example, Amazon is well-known for having more complicated algorithm problems than many other companies.

For some of the topics on this list you will want to be able to do your own implementation, while for others being familiar with how they work is likely to be sufficient.

Some of the most important patterns are:

- Binary Search
- Breadth-First Search (BFS)
- Bubble Sort
- Bucket Sort
- Cyclic Sort
- Depth-First Search (DFS)
- Dynamic Programming & Memoization
- Fast and Slow Pointers
- In-place Reversal of a LinkedList
- Fibonacci Sequence
- Gauss Sum
- Map-Reduce
- Merge Intervals
- Merge Sort
- Finding Prime Numbers
- Quick Sort
- Recursion
- Sliding Window
- Subsets
- Tree Traversals: Level-Order, Pre-Order, Post-Order
- Two Heaps
- Two Pointers

TODO: Add a brief explanation and sample implementation for each of the above patterns.

### Algorithmic Building Blocks

These are tasks that will come in handy while solving problems. While each of these is unlikely to represent an entire problem, they can be used as modular parts to quickly move through portions of a problem.

Depending on the language you are using, some of these may be easier or harder due to standard library functions. You should know how to do the following in your chosen language:

- Construct and traverse multi-dimensional arrays.
- Convert common data types into each other (strings to integers, char to integer, vice-versa, etc.)
- Find the absolute value of a number.
- Find the max (or min) value of multiple values.
- Parse a string to do things like count, remove, or add characters, extract a substring, etc.
- Split an integer into its digits (and vice-versa).
- Traverse a LinkedList with one or two pointers.
- Traverse a Tree via BFS or DFS.

TODO: Add a brief explanation and sample implementation for each of the above building blocks.

## Resources

### Algorithm Patterns

- [14 Patterns to Ace Any Coding Interview Question](https://hackernoon.com/14-patterns-to-ace-any-coding-interview-question-c5bb3357f6ed)
- [Grokking the Coding Interview (paid)](https://www.educative.io/courses/grokking-the-coding-interview)
- [Sean Prashad - LeetCode Patterns](https://github.com/SeanPrashad/leetcode-patterns)

### Big O Notation

- [Big-O Cheat Sheet](https://www.bigocheatsheet.com/)
- [What is Big O Notation](https://jarednielsen.com/big-o-notation/)

### Books

- [Cracking the Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/0984782850)
- [Mindset: The New Psychology of Success](https://www.amazon.com/Mindset-Psychology-Carol-S-Dweck/dp/0345472322)

### Company and Industry Research

- [blind](https://www.teamblind.com/)
- [glassdoor](https://www.glassdoor.com)
- [levels.fyi](https://www.levels.fyi/)

### Interviewing

- [Pramp](https://www.pramp.com/#/)

### Java

- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/)
- [Java 16 Official Docs](https://google.github.io/styleguide/javaguide.html)

### Practice Problems

- [LeetCode](https://www.leetcode.com/)
- [HackerRank](https://www.hackerrank.com/)
