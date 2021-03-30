package com.rgederin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You're given strings jewels representing the types of stones that are jewels, and stones
 * representing the stones you have. Each character in stones is a type of stone you have. You want
 * to know how many of the stones you have are also jewels.
 * <p>
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {
    /**
     * Runtime: 2 ms, faster than 17.47% of Java online submissions for Jewels and Stones. Memory
     * Usage: 37.3 MB, less than 73.03% of Java online submissions for Jewels and Stones.
     */
    public static int numJewelsInStones(String J, String S) {
        Map<Character, Integer> jewelsNumber = new HashMap<>();

        for (int i = 0; i < J.length(); i++) {
            jewelsNumber.put(J.charAt(i), 0);
        }

        for (int i = 0; i < S.length(); i++) {
            char stone = S.charAt(i);
            jewelsNumber.computeIfPresent(stone, (key, value) -> value + 1);
        }

        int jewels = 0;

        for (Integer value : jewelsNumber.values()) {
            jewels += value;
        }

        return jewels;
    }


    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(numJewelsInStones(jewels, stones));
    }
}
