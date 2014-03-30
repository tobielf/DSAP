# source: http://oj.leetcode.com/problems/single-number/
# report: 
# problem description:
# Given an array of integers, every element appears twice except for one. 
# Find that single one.

# Note:
# Your algorithm should have a linear runtime complexity. 
# Could you implement it without using extra memory?
# @author tobielf
# @date 2014/03/17

class Solution:
    # @param A, a list of integer
    # @return an integer
    def singleNumber(self, A):
        return reduce(lambda x, y: x ^ y, A)