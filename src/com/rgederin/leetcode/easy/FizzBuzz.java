package com.rgederin.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of
 * five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class FizzBuzz {
    /**
     * Runtime: 1 ms, faster than 99.77% of Java online submissions for Fizz Buzz. Memory Usage:
     * 39.7 MB, less than 95.34% of Java online submissions for Fizz Buzz.
     */
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                result.add(String.valueOf(i));
                continue;
            }

            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
                continue;
            }

            if (i % 3 == 0) {
                result.add("Fizz");
                continue;
            }

            result.add("Buzz");
        }
        return result;
    }
}
