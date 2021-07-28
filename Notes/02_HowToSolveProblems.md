# How To Solve Problems

## Mistakes

1. Jumping into your code immediately before truly understanding the problem, defining examples, or having a coherent strategy (it generally does not work out well to try and intuit your solution as you go).
2. Failing to evaluate quick test cases through your solution after you finish or as you go. In an interview environment you likely won't have an actual test runner, so usually this means manually stepping through your code with some sample inputs.
3. Failing to look for improvements or optimizations in your code (ex: "what could I do to take this solution from O(n) space to O(1) space?").

---

## 7 Step Framework for Solving Problems (adapted from CtCI)

1. **Listen Carefully**
    * Almost all details are useful: look for small clues in the problem description that can shed light on implicit constraints in your solution or wrinkles that may be introduced by the interviewer later in the problem.
    * Ask any clarifying questions you have. This not only solidifies your own understanding but also communicates to the interviewer that you are thinking deeply about the problem.
    * Don't move on until you understand the problem fully.
2. **Make Examples**
    * These should be specific, sufficiently large, and include a few edge cases (0, null, negatives, bad data, input too large, too small, etc.)
    * Sometimes these will be provided by the problem prompt, but make sure you look at them and consider them, and see if any more would be helpful.
3. **State the Simple Solution**
    * This is often the "brute force" solution and demonstrates to your interviewer you understand the problem and the conceptual solution to it.
    * At this stage, you are not writing much / any code.
4. **Optimize your Solution**
    * You are still not writing much / any code, but are considering how you might improve the niave solution stated in #3 above.
    * You should be familiar enough with Big O patterns to identify the Best-Case Runtime (BCR) of any algorithmic solution to the problem.
5. **Walk Through Your Algorithm**
    * Solidify your understanding of the algorithm.
    * Aim for 100% comprehension of how your solution works before you start writing code.
6. **Actually Write Your Code**
    * Consider good style and design, even when white-boarding or using a text editor.
    * Write the kind of quality code you'd commit to a project repo (good names, proper formatting, helper methods, etc.) not the kind of terse and clever code you will often see on LeetCode, etc.
7. **Test**
    * Manually run your test cases from #2 through your solution.
    * Explain your code to your interviewer like you would in a code review.

---

## Other Tips

* Keep maps / hashsets at the top of your mind as they are very common and extremely useful for optimizations.
* Remember that interview problems are designed to be solved!
* Start by filtering out data structures that aren't useful or relevant to the problem, or that don't meet the complexity requirements.
* Slow down, take a breath, and don't panic. *How* you approach a problem is important also, not just *if* you solve it. Even if you don't get a 100% solution to a problem, you can still have a decent interview.
* Ask yourself "how would a human solve this?" This can often reveal the algorithmic trick that our brains intuitively use to solve problems.
* First solve for the simplified version of a problem, then adapt for a more complex version (establish a base case, then build on it).
