package com.rgederin.leetcode.easy;

/**
 * 1470. Shuffle the Array
 */
public class ShuffleArray {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Shuffle the Array. Memory
     * Usage: 39 MB, less than 62.17% of Java online submissions for Shuffle the Array.
     */
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];

        int x = 0;
        int y = 1;

        for (int i = 0; i < n; i++) {
            result[x] = nums[i];
            x += 2;
        }

        for (int i = n; i < 2 * n; i++) {
            result[y] = nums[i];
            y += 2;
        }

        return result;
    }

    public int[] shuffleSimplier(int[] nums, int n) {
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[2 * i] = nums[i];
            result[(2 * i) + 1] = nums[i + n];

        }
        return result;
    }
}
