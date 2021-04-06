package com.rgederin.leetcode.easy;

/**
 * 520. Detect Capital
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA". All letters in this word are not capitals,
 * like "leetcode". Only the first letter in this word is capital, like "Google". Otherwise, we
 * define that this word doesn't use capitals in a right way.
 */
public class DetectCapital {

    /**
     * Runtime: 1 ms, faster than 99.08% of Java online submissions for Detect Capital. Memory
     * Usage: 37.1 MB, less than 83.69% of Java online submissions for Detect Capital.
     */
    public boolean detectCapitalUse(String word) {

        return isFirstUpperCaseAndRestNope(word)
                || isAllLowerCase(word)
                || isAllUpperCase(word);
    }

    private boolean isLowerCase(char ch) {
        return ch >= 97 && ch <= 122;
    }

    private boolean isFirstUpperCaseAndRestNope(String word) {
        if (isLowerCase(word.charAt(0))) {
            return false;
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (!isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean isAllUpperCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean isAllLowerCase(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!isLowerCase(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
