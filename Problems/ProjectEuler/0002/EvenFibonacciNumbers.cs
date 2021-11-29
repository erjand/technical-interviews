﻿// https://projecteuler.net/problem=2
//
// Each new term in the Fibonacci sequence is generated by adding the previous two terms. 
// By starting with 1 and 2, the first 10 terms will be:
// 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
// By considering the terms in the Fibonacci sequence whose values do not exceed four million, 
// find the sum of the even-valued terms.


// Time: O(1) because we know we are only calculating the sums below 4M.
// Space: O(1)
public class Solution
{
	public int EvenFibonacciNumbers()
	{
		var fibonacciOne = 1;
		var fibonacciTwo = 1;
		var fibonacciSum = 0;

		var evenRunningTotal = 0;

		while (fibonacciSum < 4000000)
		{
			if (fibonacciSum % 2 == 0)
			{
				evenRunningTotal += fibonacciSum;
			}

			fibonacciSum = fibonacciOne + fibonacciTwo;
			fibonacciOne = fibonacciTwo;
			fibonacciTwo = fibonacciSum;
		}

		return evenRunningTotal;
	}
}