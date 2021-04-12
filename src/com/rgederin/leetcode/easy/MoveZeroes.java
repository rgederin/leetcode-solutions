package com.rgederin.leetcode.easy;

/**
 * 283. Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order
 * of the non-zero elements.
 */
public class MoveZeroes {
    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes. Memory Usage:
     * 38.9 MB, less than 89.15% of Java online submissions for Move Zeroes.
     */
    public void moveZeroes(int[] nums) {
        int[] tmp = new int[nums.length];

        for (int i = 0, j = nums.length - 1, k = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                tmp[j] = nums[i];
                j--;
            } else {
                tmp[k] = nums[i];
                k++;
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        new MoveZeroes().moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
