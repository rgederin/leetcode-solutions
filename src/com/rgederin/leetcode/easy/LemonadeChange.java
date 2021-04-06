package com.rgederin.leetcode.easy;

/**
 * 860. Lemonade Change
 * <p>
 * At a lemonade stand, each lemonade costs $5.
 * <p>
 * Customers are standing in a queue to buy from you, and order one at a time (in the order
 * specified by bills).
 * <p>
 * Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  You must
 * provide the correct change to each customer, so that the net transaction is that the customer
 * pays $5.
 * <p>
 * Note that you don't have any change in hand at first.
 * <p>
 * Return true if and only if you can provide every customer with correct change.
 */
public class LemonadeChange {
    private int five;
    private int ten;

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Lemonade Change. Memory
     * Usage: 39.8 MB, less than 79.43% of Java online submissions for Lemonade Change.
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        for (int i = 0; i < bills.length; i++) {
            boolean valid = processBill(bills[i]);
            if (!valid) {
                return false;
            }
        }

        return true;
    }

    private boolean processBill(int bill) {
        switch (bill) {
            case 5:
                five++;
                return true;
            case 10:
                if (five >= 1) {
                    ten++;
                    five--;
                    return true;
                }
                return false;
            case 20:
                if (ten >= 1 && five >= 1) {
                    ten--;
                    five--;
                    return true;
                }
                if (five >= 3) {
                    five -= 3;
                    return true;
                }

                return false;
            default:
                throw new IllegalStateException("Unexpected value: " + bill);
        }
    }
}

//Input: [5,5,5,10,20]
//Output: true