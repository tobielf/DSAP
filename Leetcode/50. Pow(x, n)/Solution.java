/**
 * Divide and Conquer with memorization.
 */
class Solution {

    private double pow(double x, long n) {
        /**
         * Using long type as parameter to avoid the overflow issue.
         */
        double ans;
        // Base cases
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        // Memorization, we don't need to recompute the same result.
        ans = pow(x, n/2);
        if (n % 2 == 1)
            return ans * ans * x;
        else
            return ans * ans;
    }

    public double myPow(double x, int n) {
        /**
         * Calling interface, x to the power -n, can be converted to 1/x to the power n.
         */
        if (n == 0)
            return 1;
        if (n < 0)
            return pow(1/x, -(long)n);
        else
            return pow(x, n);
    }
}