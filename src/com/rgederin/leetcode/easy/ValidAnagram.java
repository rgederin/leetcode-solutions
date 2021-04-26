package com.rgederin.leetcode.easy;

import java.util.Arrays;

public class ValidAnagram {

    /**
     * Runtime: 2 ms, faster than 94.03% of Java online submissions for Valid Anagram.
     * Memory Usage: 39.2 MB, less than 57.39% of Java online submissions for Valid Anagram.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        char[] ch1 = s.toCharArray();
        char[] ch2 = t.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        for (int i = 0; i< ch1.length; i++){
            if (ch1[i] != ch2[i]){
                return false;
            }
        }

        return true;
    }
}
