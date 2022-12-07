/*
Problem Source:
https://projecteuler.net/problem=1

Problem Statement:
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
Find the sum of all the multiples of 3 or 5 below 1000.
*/

// Time: O(1) because we know we are only calculating the sums below 1000.
// Space: O(1)
public class Solution
{
	public int SumMultiplesOfThreeAndFive()
	{
		var sum = 0;

		for (var i = 0; i < 1000; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
			{
				sum += i;
			}
		}

		return sum;
	}
}