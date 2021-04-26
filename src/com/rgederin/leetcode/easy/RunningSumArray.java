package com.rgederin.leetcode.easy;

/**
 * 1480. Running Sum of 1d Array
 */
public class RunningSumArray {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Running Sum of 1d Array.
     * Memory Usage: 38.7 MB, less than 97.86% of Java online submissions for Running Sum of 1d
     * Array.
     */
    public int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            runningSum[i] = sum;
        }
        return runningSum;
    }

    public static void main(String[] args) {
        int[] arr = new RunningSumArray().runningSum(new int[]{1, 2, 3, 4});
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
