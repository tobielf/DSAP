/**
 * Problem analysis
 * 1. Keep counting from left to right, like: abcdefg
 * 2. Keep tracking the most recent position of the character, by i + 1
 * 3. The left most boundary updated by the last duplicated character.
 * "abcdefb" updated left to 3 (duplicated 'b'),
 * "abcdefba" in this case the last 'a' will not update the left boundary.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int longest = 0;
        int dict[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            left = Math.max(left, dict[s.charAt(i)]);
            longest = Math.max(longest, i - left + 1);
            dict[s.charAt(i)] = i + 1;
        }
        return longest;
    }
}