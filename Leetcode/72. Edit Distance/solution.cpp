class Solution {
public:
    int minDistance(string word1, string word2) {
        auto distance = vector<vector<int>>(word1.size() + 1, vector<int>(word2.size() + 1, 0));
        // Well known dynamic programming problem. 

        // [i][0] means from source string of length i to target string of length 0, so we need to delete i times.
        for (int i = 0; i <= word1.size(); ++i) {
            distance[i][0] = i;
        }

        // [0][j] means from source string of length 0 to target string of length j, so we need to insert j times.
        for (int j = 0; j <= word2.size(); ++j) {
            distance[0][j] = j;
        }
        for (int i = 1; i <= word1.size(); ++i) {
            for (int j = 1; j <= word2.size(); ++j) {
                if (word1[i - 1] == word2[j - 1]) {
                    // if they are equaled, no operation needed.
                    distance[i][j] = distance[i - 1][j - 1];
                } else {
                    // distance[i - 1][j] means delete one character,
                    // distance[i][j - 1] means insert one character,
                    // distance[i - 1][j - 1] means replace one character.
                    distance[i][j] = min(min(distance[i - 1][j], distance[i][j - 1]), distance[i - 1][j - 1]);
                    distance[i][j]++;
                }
            }
        }
        return distance[word1.size()][word2.size()];
    }
};