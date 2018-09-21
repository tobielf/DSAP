/**
 * Analysis: This is an alternative version of binary search.
 * Since the array was rotated sorted, therefore the mid could be greater than the right.
 * We keep trimming the left(bigger part) of the array, until we reached the smaller half.
 * Then we trimming the right(relatively smaller part) of the array, until we find the minimum.
 * The time complexity is O(logN).
 *
 * Another approach is we scan the array from left to right
 * stop when we see an element smaller than both side.
 * I didn't try this idea, but it should work on O(N).
 */
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left];
    }
}