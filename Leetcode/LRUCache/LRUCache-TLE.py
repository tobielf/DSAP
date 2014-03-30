# source:http://oj.leetcode.com/problems/lru-cache/
# report:

# Problem Description:
# Design and implement a data structure for Least Recently Used (LRU) cache. 
# It should support the following operations: get and set.
# get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
# set(key, value) - Set or insert the value if the key is not already present. 
# When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

# @author: tobielf
# @date: 2014/03/22

class LRUCache:

    # @param capacity, an integer
    def __init__(self, capacity):
        self.capacity = capacity
        self.storage = {}
        self.keys = []
        self.size = 0

    # @return an integer
    def get(self, key):
        if key in self.keys:
            self.keys.remove(key)
            self.append(key)
            return self.storage[key]
        return -1
    # @param key, an integer
    # @param value, an integer
    # @return nothing
    def set(self, key, value):
        if key in self.keys:
            self.keys.remove(key)
            self.size = self.size - 1
        self.keys.append(key)
        self.storage[key] = value
        self.size = self.size + 1

        if self.size == self.capacity:
            del self.storage[self.keys[0]]

