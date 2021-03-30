package com.rgederin.leetcode.easy;

/**
 * 657 - easy
 * <p>
 * There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its
 * moves, judge if this robot ends up at (0, 0) after it completes its moves.
 * <p>
 * The move sequence is represented by a string, and the character moves[i] represents its ith move.
 * Valid moves are R (right), L (left), U (up), and D (down). If the robot returns to the origin
 * after it finishes all of its moves, return true. Otherwise, return false.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to
 * the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the
 * robot's movement is the same for each move.
 */
public class RobotReturnToOrigin {

    /**
     * Runtime: 5 ms, faster than 51.70% of Java online submissions for Robot Return to Origin.
     * Memory Usage: 38.9 MB, less than 55.84% of Java online submissions for Robot Return to
     * Origin.
     */
    public static boolean judgeCircle(String moves) {
        int[] position = {0, 0};

        for (int i = 0; i < moves.length(); i++) {
            char step = moves.charAt(i);
            makeStep(position, step);
        }

        return position[0] == 0 && position[1] == 0;
    }

    private static void makeStep(int[] poisition, char step) {
        switch (step) {
            case 'U':
                poisition[0] += 1;
                break;
            case 'D':
                poisition[0] -= 1;
                break;
            case 'L':
                poisition[1] -= 1;
                break;
            case 'R':
                poisition[1] += 1;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + step);
        }
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("UD"));
        System.out.println(judgeCircle("LLUDRR"));
    }
}
