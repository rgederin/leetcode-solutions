from typing import List


class Solution:

    # Runtime: 1040 ms, faster than 69.47% of Python3 online submissions for Best Time to Buy and Sell Stock.
    # Memory Usage: 25.1 MB, less than 52.04% of Python3 online submissions for Best Time to Buy and Sell Stock.
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        profit = 0
        curr_profit = 0

        for i in range(1, len(prices)):
            if prices[i] < buy and i != len(prices) - 1:
                buy = prices[i]
                continue

            if prices[i] >= buy:
                curr_profit = prices[i] - buy
                if curr_profit > profit:
                    profit = curr_profit
                continue
        return profit
