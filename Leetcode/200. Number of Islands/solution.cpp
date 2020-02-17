#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    int directions[4][2] = { {0, 1}, {-1, 0}, {0, -1}, {1, 0} };
    
    bool inBound(vector<vector<char>>& grid, int r, int c) {
        return (r >= 0) && (c >= 0) && (r < grid.size()) && (c < grid[0].size());
    }
    
    void bfs(vector<vector<char>>& grid, int r, int c) {
        grid[r][c] = '0';
        for (int dir = 0; dir < 4; ++dir) {
            int newR = r + directions[dir][0];
            int newC = c + directions[dir][1];
            if (inBound(grid, newR, newC) && (grid[newR][newC] == '1'))
                bfs(grid, newR, newC);
        }
    }
    
    int numIslands(vector<vector<char>>& grid) {
        int cnt = 0;
        for (int row = 0; row < grid.size(); ++row) {
            for (int col = 0; col < grid[0].size(); ++col) {
                if (grid[row][col] == '1') {
                    ++cnt;
                    bfs(grid, row, col);
                }
            }
        }
        return cnt;
    }
};