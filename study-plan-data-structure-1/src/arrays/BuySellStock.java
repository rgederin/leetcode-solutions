package arrays;

/**
 * 121. Best Time to Buy and Sell Stock (easy)
 * <p>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BuySellStock {
    /**
     * Runtime: 2 ms, faster than 71.05% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 52 MB, less than 81.15% of Java online submissions for Best Time to Buy and Sell Stock.
     */
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int currentProfit = 0;

        for (int i = 1; i < prices.length; i++){
            if (prices[i] < buy && i != prices.length - 1){
                buy = prices[i];
                continue;
            }

            if (prices[i] >= buy){
                currentProfit = prices[i] - buy;

                if (currentProfit > profit){
                    profit = currentProfit;
                }
            }
        }

        return profit;
    }
}