# source: http://oj.leetcode.com/problems/candy/
# report:

# Problem Description:
# There are N children standing in a line. Each child is assigned a rating value.
# You are giving candies to these children subjected to the following requirements:
# 	Each child must have at least one candy.
# 	Children with a higher rating get more candies than their neighbors.
# What is the minimum candies you must give?

# @author: tobielf
# @date: 2014/03/29

class Solution:
	# @param ratings, a list of integer
	# @return an integer
	def candy(self, ratings):
		length = len(ratings)
		candys = [1] * length
		#First time,we make a forward scan, dealing with ascending situations.
		for x in xrange(1,length):
			if ratings[x] > ratings[x - 1]:
				candys[x] = candys[x - 1] + 1
		#Second time,we make a backward scan, dealing with descending situations.
		#NOTE:  we treat descending situation as same as the ascending one.
		#		but, beware of the peak point of each boundary.
		#Exapmle: 1 2 3 4 5 3 2 1
		#		so, candys[x] <= candys[x + 1] must be contented.
		for x in xrange(length - 2, -1, -1):
			if ratings[x] > ratings[x + 1] and candys[x] <= candys[x + 1]:
				candys[x] = candys[x + 1] + 1

		# sum is equivalent to reduce(...), thanks for Anna's help
		print sum(candys)
		#print reduce(lambda x, y: x + y, candys)

s = Solution()
s.candy([2,1,3,4])