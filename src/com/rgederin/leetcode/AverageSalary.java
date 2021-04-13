package com.rgederin.leetcode;

import java.util.Arrays;

/**
 * 1491. Average Salary Excluding the Minimum and Maximum Salary
 *
 * Given an array of unique integers salary where salary[i] is the salary of the employee i.
 *
 * Return the average salary of employees excluding the minimum and maximum salary.
 */
public class AverageSalary {

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * Memory Usage: 36.5 MB, less than 77.89% of Java online submissions for Average Salary Excluding the Minimum and Maximum Salary.
     * @param salary
     * @return
     */
    public double average(int[] salary) {
        Arrays.sort(salary);

        double sum = 0;

        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }

        return sum / (salary.length - 2);
    }

}
