class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int peak = 1;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1] && A[i] > A[peak])
                peak = i;
        }
        return peak;
    }
}