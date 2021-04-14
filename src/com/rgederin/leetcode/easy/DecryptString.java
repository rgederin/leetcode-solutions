package com.rgederin.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 1309. Decrypt String from Alphabet to Integer Mapping
 */
public class DecryptString {
    private final Map<String, String> map = initMap();

    private Map<String, String> initMap() {
        Map<String, String> map = new HashMap<>();

        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10#", "j");
        map.put("11#", "k");
        map.put("12#", "l");
        map.put("13#", "m");
        map.put("14#", "n");
        map.put("15#", "o");
        map.put("16#", "p");
        map.put("17#", "q");
        map.put("18#", "r");
        map.put("19#", "s");
        map.put("20#", "t");
        map.put("21#", "u");
        map.put("22#", "v");
        map.put("23#", "w");
        map.put("24#", "x");
        map.put("25#", "y");
        map.put("26#", "z");

        return map;
    }

    /**
     * Runtime: 1 ms, faster than 63.84% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     * Memory Usage: 37.2 MB, less than 58.74% of Java online submissions for Decrypt String from Alphabet to Integer Mapping.
     */
    public String freqAlphabets(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0, j = i + 2; i < s.length(); i++) {

            if (i == s.length() - 1 || i == s.length() - 2) {
                builder.append(map.get(String.valueOf(s.charAt(i))));
                continue;
            }

            if ('#' == s.charAt(j)) {
                builder.append(map.get(s.substring(i, j + 1)));
                i += 2;
                j += 3;
            } else {
                builder.append(map.get(String.valueOf(s.charAt(i))));
                j++;
            }
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        new DecryptString().freqAlphabets("310#11#");
    }
}
