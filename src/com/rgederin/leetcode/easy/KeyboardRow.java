package com.rgederin.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 500. Keyboard Row
 *
 * Given an array of strings words, return the words that can be typed using letters of the alphabet
 * on only one row of American keyboard like the image below.
 */
public class KeyboardRow {
    private Set<Character> firstRow = initRows("qwertyuiop");
    private Set<Character> secondRow = initRows("asdfghjkl");
    private Set<Character> thirdRow = initRows("zxcvbnm");

    private HashSet<Character> initRows(String chars) {
        return (HashSet<Character>) chars.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
    }

    private boolean processWord(String word) {
        word = word.toLowerCase();
        boolean valid = true;
        for (int i = 0; i < word.length(); i++) {
            if (!firstRow.contains(word.charAt(i))) {
                valid = false;
                break;
            }
        }

        if (valid) {
            return valid;
        }

        valid = true;
        for (int i = 0; i < word.length(); i++) {
            if (!secondRow.contains(word.charAt(i))) {
                valid = false;
                break;
            }
        }

        if (valid) {
            return valid;
        }

        valid = true;
        for (int i = 0; i < word.length(); i++) {
            if (!thirdRow.contains(word.charAt(i))) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    /**
     * Runtime: 5 ms, faster than 7.48% of Java online submissions for Keyboard Row. Memory Usage:
     * 37 MB, less than 61.37% of Java online submissions for Keyboard Row.
     *
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        return Arrays.stream(words).filter(this::processWord).toArray(String[]::new);
    }

    public static void main(String[] args) {

        KeyboardRow keyboardRow = new KeyboardRow();

        String[] arr = {"Hello", "Alaska", "Dad", "Peace"};

        System.out.println(keyboardRow.findWords(arr).length);
    }
}
