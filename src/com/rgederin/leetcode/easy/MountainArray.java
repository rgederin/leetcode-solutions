package com.rgederin.leetcode.easy;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 */
public class MountainArray {

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Mountain Array.
     * Memory Usage: 40.5 MB, less than 100.00% of Java online submissions for Valid Mountain Array.
     */
    public static boolean validMountainArray(int[] arr) {
        boolean increases = false;
        boolean decreases = false;

        if (arr.length < 2) return false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if (decreases) {
                    return false;
                }
                increases = true;
            } else if (arr[i] < arr[i - 1]) {
                if (!increases) {
                    return false;
                }
                decreases = true;
            } else {
                return false;
            }
        }
        return increases && decreases;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
    }
}
