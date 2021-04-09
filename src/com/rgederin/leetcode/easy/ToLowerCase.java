package com.rgederin.leetcode.easy;

/**
 * 709. To Lower Case
 *
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 */
public class ToLowerCase {

    private static final byte A_ASCII = 65;
    private static final byte Z_ASCII = 90;
    private static final byte ASCII_OFFSET = 32;

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case. Memory
     * Usage: 37 MB, less than 27.48% of Java online submissions for To Lower Case.
     *
     */
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (isUpperCase(ch)) {
                ch = (char) toLowerCase(ch);
            }

            builder.append(ch);
        }

        return builder.toString();
    }

    private boolean isUpperCase(char ch) {
        return ch >= A_ASCII && ch <= Z_ASCII;
    }

    private int toLowerCase(char ch) {
        return ch + ASCII_OFFSET;
    }
}
