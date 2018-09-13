/**
 * Analysis
 * It’s a search problem, at the first glance.
 * We only can flip 20*20 lines at any(d) time, which create a exponential search space. d^400.
 * A brute force approach, trying all the combination of flipping and get the result will fail on this case.
 *
 * So we need a heuristic function to prune the search tree(space).
 *
 * The first heuristic came to my mind was greedy algorithm.
 * The score mechanism lead us to greedy on the number of 0s in the matrix. And the score calculated by row based.
 * Firstly, let’s look into the row score.
 * If a row is 0001111 (with any leading zeros), flip it will give us higher score, 1110000.
 * In the contrast, if a row is 10100001 (the highest bit is 1), flip it, will lower the score,01011110.
 *   0. So we want to make all the highest bit in each row to ‘1’ first.
 *
 * Based on the previous step, then we try to reduce the total zeros in second highest bit, third highest bit and so on.
 *   1. Finding the most zeros and flip this line.
 * 0000 -> 1111 will be great!
 * However, noticed that one problem came up, if the line contains not only 0s but also 1s.
 * Those 1s will turn into 0s after the flip.
 * 0001 -> 1110, not bad. 1011 -> 0100, bad.
 * As a result, we updated our greedy policy to:
 *   2. Finding the absolute most zeros, #0s - #1s.
 * So we will flip 0001 to 1110, but not in a reverse way, since the value we got is negative.
 * It completes the whole algorithm.
 */
class Solution {
    private int countZeros(int bit, int[][] A) {
        int cnt = 0;
        int rows = A.length;
        /** Counting bits in certain column */
        for (int i = 0; i < rows; i++) {
            if (A[i][bit] == 0)
                cnt++;
        }
        return cnt;
    }
    private int calculateScore(int [][] A) {
        int score = 0;
        int rows = A.length;
        int cols = A[0].length;
        for (int i = 0; i < rows; i++) {
            int s = 0;
            /** Converting from bits to number */
            for (int j = 0; j < cols; j++) {
                s <<= 1;
                s += A[i][j];
            }
            score += s;
        }
        return score;
    }
    public int matrixScore(int[][] A) {
        int score = 0;
        int rows = A.length;
        int cols = A[0].length;
        /** 1. We want to make all the highest bit in each row to ‘1’ first. */
        for (int i = 0; i < rows; i++) {
            if (A[i][0] == 0)
                for (int j = 0; j < cols; j++)
                    A[i][j] = 1 - A[i][j];
        }

        /** 2. Finding the absolute most zeros, #0s - #1s. And flip this column*/
        for (int j = 1; j < cols; j++) {
            int zeros = countZeros(j, A);
            if (zeros > rows - zeros)
                for (int i = 0; i < rows; i++)
                    A[i][j] = 1 - A[i][j];
        }

        /** 3. Get the score */
        score = calculateScore(A);
        return score;
    }
}