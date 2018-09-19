/**
 * Tree style Dynamic Programming (树形DP)
 * Idea, analysis
 * The larger number's factor depends on the smaller number's result.
 * To find the factor, we can just iterate through the 1000 number.
 * Note: 1. Must using Long datatype to avoid the overflow.
 *       2. Don't forget to mod 1000000007
 */
class Solution {
    public int numFactoredBinaryTrees(int[] A) {
        HashMap<Integer, Long> solved = new HashMap<>();
        long ans = 0;
        /** 1. Sort the number in ascending way */
        Arrays.sort(A);
        /** 2. Calculate each one */
        for (int i = 0; i < A.length; i++) {
            long cnt = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] % A[j] == 0 && solved.containsKey(A[i] / A[j]))
                    cnt += (solved.get(A[i] / A[j]) * solved.get(A[j])) % 1000000007;
            }
            solved.put(A[i], cnt);
            ans = (ans + cnt) % 1000000007;
        }
        return (int)ans;
    }
}