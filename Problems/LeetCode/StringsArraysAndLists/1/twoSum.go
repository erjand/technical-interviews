// LeetCode #1
// https://leetcode.com/problems/two-sum/
//
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
// You can return the answer in any order.

package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}

func twoSum(nums []int, target int) []int {
	var numHash = make(map[int]int)

	for i := 0; i < len(nums); i++ {
		value, hasComplement := numHash[target-nums[i]]

		if hasComplement {
			return []int{i, value}
		}

		numHash[nums[i]] = i
	}

	return []int{}
}
