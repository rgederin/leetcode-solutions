package com.rgederin.leetcode.easy;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
 * Memory Usage: 36 MB, less than 86.30% of Java online submissions for Hamming Distance.
 */
public class HammingDistance {

    /**
     * Calculate the XOR of two numbers.
     * Count the number of set bits.
     */
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int setBits = 0;

        while (xor > 0) {
            setBits += xor & 1;
            xor >>= 1;
        }

        return setBits;
    }
}
