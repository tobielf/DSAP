/**
 * Clarification
 * Duplicated characters counted only once?
 * T = "AA"
 * S = "A"
 *
 * All in upper case? no lower case?
 *
 * Naive solution, O(n^2)
 * staring from each location and moving forward until we got all characters
 *
 * Thers are many duplicated computations in naive solution.
 * Why stop at the location we found the answer, how about keep going?
 */
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string minWindow(string s, string t) {
        int start = 0;
        int end = 0;
        int min_length = s.size() + 1;
        int ans = 0;
        auto to_cover = vector<int>(128, 0);
        auto contained = vector<bool>(128, false);
        int cnt = 0;
        
        for (end = 0; end < t.size(); ++end) {
            to_cover[t[end] - 'A'] -= 1;
            contained[t[end] - 'A'] = true;
        }
        
        for (end = 0; end < s.size(); ++end) {
            // Collect all characters.
            if (to_cover[s[end] - 'A'] < 0) {
                ++cnt;
            }
            to_cover[s[end] - 'A']++;
            
            if (cnt < t.size())
                continue;
            
            // All collected, try to shrink the lengths.
            while (to_cover[s[start] - 'A'] >= 0 && start < end) {
                if (contained[s[start] - 'A'] && to_cover[s[start] - 'A'] <= 0)
                    break;

                to_cover[s[start] - 'A']--;
                start++;
            }
            
            // Update min_length
            if (min_length > (end - start + 1)) {
                min_length = end - start + 1;
                ans = start;
            }
        }
        
        if (min_length > s.size())
            return "";
        else
            return s.substr(ans, min_length);
    }
};