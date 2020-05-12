package com.rgederin.leetcode.easy;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 */
public class ReverseWordsInString {
    /**
     * Runtime: 20 ms, faster than 16.52% of Java online submissions for Reverse Words in a String
     * III. Memory Usage: 40.6 MB, less than 21.05% of Java online submissions for Reverse Words in
     * a String III.
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        String result = "";
        for (String string : split) {
            result += new StringBuilder(string).reverse();
            result += " ";
        }

        return result.trim();
    }
}
