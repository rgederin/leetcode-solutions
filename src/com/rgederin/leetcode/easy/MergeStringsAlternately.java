package com.rgederin.leetcode.easy;

/**
 * 1768. Merge Strings Alternately
 * <p>
 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating
 * order, starting with word1. If a string is longer than the other, append the additional letters
 * onto the end of the merged string.
 * <p>
 * Return the merged string
 */
public class MergeStringsAlternately {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Strings Alternately.
     * Memory Usage: 37 MB, less than 98.27% of Java online submissions for Merge Strings
     * Alternately.
     */
    public static String mergeAlternately(String word1, String word2) {
        int firstLength = word1.length();
        int secondLength = word2.length();

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        int j = 0;
        while (i < firstLength || j < secondLength) {
            if (i < firstLength) {
                stringBuilder.append(word1.charAt(i));
                i++;
            }
            if (j < secondLength) {
                stringBuilder.append(word2.charAt(j));
                j++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "def";

        System.out.println(mergeAlternately(s1, s2));
    }
}
