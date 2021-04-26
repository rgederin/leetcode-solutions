package com.rgederin.leetcode.easy;

import java.util.Arrays;

public class HeightChecker {
    /**
     * Runtime: 1 ms, faster than 77.93% of Java online submissions for Height Checker. Memory
     * Usage: 36.9 MB, less than 17.03% of Java online submissions for Height Checker.
     */
    public int heightChecker(int[] heights) {
        int[] temp = heights.clone();

        Arrays.sort(heights);

        int diffs = 0;
        for (int i = 0; i < heights.length; i++) {
            if (temp[i] != heights[i]) {
                diffs++;
            }
        }

        return diffs;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 4, 2, 1, 3};

        new HeightChecker().heightChecker(arr);
    }
}
