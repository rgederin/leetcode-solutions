package com.rgederin.leetcode.easy;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Student Attendance Record I.
 * Memory Usage: 39.1 MB, less than 10.58% of Java online submissions for Student Attendance Record I.
 */
public class StudentAttendance {
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'L') l++;
            if (ch == 'A' ) {
                a++;
                l = 0;
            }
            if (ch == 'P') l = 0;
            if (a > 1) return false;
            if (l > 2) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        StudentAttendance studentAttendance = new StudentAttendance();

        studentAttendance.checkRecord("PPALLL");
    }
}
