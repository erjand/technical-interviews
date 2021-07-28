# LeetCode #1
# https://leetcode.com/problems/two-sum/
# 
# Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
# You may assume that each input would have exactly one solution, and you may not use the same element twice.
# You can return the answer in any order.

# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}

# Time: O(n)
# Space: O(n)
def two_sum(nums, target)       
    num_hash = {}
    nums.each_with_index do |n, index|       
        if (num_hash[target - n])
            return [num_hash[target - n], index]
        else
            num_hash.store(n, index)
        end
    end
end