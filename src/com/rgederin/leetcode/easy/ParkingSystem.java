package com.rgederin.leetcode.easy;


/**
 * 1603 Design a parking system
 * <p>
 * Design a parking system for a parking lot. The parking lot has three kinds of parking spaces:
 * big, medium, and small, with a fixed number of slots for each size.
 * <p>
 * Runtime: 6 ms, faster than 99.87% of Java online submissions for Design Parking System. Memory
 * Usage: 39.8 MB, less than 40.56% of Java online submissions for Design Parking System.
 */
public class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1:
                if (0 != big) {
                    big--;
                    return true;
                }
                break;
            case 2:
                if (0 != medium) {
                    medium--;
                    return true;
                }
                break;
            case 3:
                if (0 != small) {
                    small--;
                    return true;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + carType);
        }
        return false;
    }
}
