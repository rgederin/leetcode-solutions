package com.rgederin.leetcode.easy;

public class FibonacciNumber {
    /**
     * Runtime: 19 ms, faster than 5.14% of Java online submissions for Fibonacci Number.
     * Memory Usage: 38.8 MB, less than 5.00% of Java online submissions for Fibonacci Number.
     */
    public int fibRecursive(int N) {
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        return fibRecursive(N - 2) + fibRecursive(N - 1);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 38.2 MB, less than 7.68% of Java online submissions for Fibonacci Number.
     */
    public int fibLinear(int N) {
        if (N == 0) {
            return 0;
        }
        if (N == 1 || N == 2) {
            return 1;
        }
        int preLast = 1;
        int last = 1;
        int answer = 0;

        for (int i = 2; i < N; i++) {
            answer = preLast + last;
            preLast = last;
            last = answer;
        }

        return answer;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
     * Memory Usage: 36.2 MB, less than 56.81% of Java online submissions for Fibonacci Number.
     */
    public int fibBinet(int N) {
        return (int) ((Math.pow(1 + Math.sqrt(5), N) - Math.pow(1 - Math.sqrt(5), N)) /
                        (Math.pow(2, N) * Math.sqrt(5)));
    }
}
