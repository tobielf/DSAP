/**
 * Clarify on boundary, directions
 * cross boundary will be considered as adjacent or not?
 * input will always be valid?
 * empty string? true or false?
 */
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    int directions[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };

    bool inBound(vector<vector<char>>& board, int r, int c) {
        return (r >= 0) && (c >= 0) && (r < board.size()) && (c < board[0].size());
    }

    bool dfs(vector<vector<char>>& board, int r, int c, string word, int pos, vector<vector<bool>>& visited) {
        if (pos == word.size())
            return true;
        
        // Set flag before visiting.
        visited[r][c] = true;
        
        for (int dir = 0; dir < 4; ++dir) {
            int newR = r + directions[dir][0];
            int newC = c + directions[dir][1];
            
            // Short circuit so it guaranteed the valid newR newC used in future conditions.
            if (inBound(board, newR, newC) && !visited[newR][newC] && board[newR][newC] == word[pos]) {
                if (dfs(board, newR, newC, word, pos + 1, visited))
                    return true;
            }
        }
        
        // Restore flag after visiting.
        visited[r][c] = false;
        
        return false;
    }
    bool exist(vector<vector<char>>& board, string word) {
        for (int row = 0; row < board.size(); ++row) {
            for (int col = 0; col < board[row].size(); ++col) {
                if (board[row][col] == word[0]) {
                    auto visited = vector<vector<bool> >(board.size(), vector<bool>(board[row].size(), false));
                    if (dfs(board, row, col, word, 1, visited))
                        return true;
                }
            }
        }
        return false;
    }
};