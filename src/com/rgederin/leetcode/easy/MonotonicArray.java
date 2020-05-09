package com.rgederin.leetcode.easy;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 */
public class MonotonicArray {
    /**
     * Runtime: 1 ms, faster than 99.97% of Java online submissions for Monotonic Array. Memory
     * Usage: 48 MB, less than 100.00% of Java online submissions for Monotonic Array.
     */
    public boolean isMonotonic(int[] A) {
        boolean increases = false;
        boolean decreases = false;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                increases = true;
                if (decreases) {
                    return false;
                }
            } else if (A[i] < A[i - 1]) {
                decreases = true;
                if (increases) {
                    return false;
                }
            }
        }

        return true;
    }

}
