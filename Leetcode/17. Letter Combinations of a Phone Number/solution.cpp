#include <vector>
#include <list>
#include <string>
using namespace std;

class Solution {
public:
    vector<string> letters = { "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    vector<string> letterCombinations(string digits) {
        if (digits.size() == 0)
            return vector<string>();

        list<string> result = { "" };
        for (int pos = 0; pos < digits.size(); ++pos) {
            while (result.front().size() <= pos) {
                string top = result.front();
                result.pop_front();
                for (int i = 0; i < letters[digits[pos] - '2'].size(); ++i) {
                    result.push_back(top + letters[digits[pos] - '2'][i]);
                }
            }
        }
        return vector<string>(result.begin(), result.end());
    }
};