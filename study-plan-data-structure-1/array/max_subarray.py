from typing import List


class Solution:
    # Runtime: 716 ms, faster than 5.88% of Python3 online submissions for Maximum Subarray.
    # Memory Usage: 28.7 MB, less than 5.41% of Python3 online submissions for Maximum Subarray.
    def maxSubArray(self, nums: List[int]) -> int:
        max_sum = nums[0]
        cur_sum = 0

        for num in nums:
            if cur_sum < 0:
                cur_sum = 0
            cur_sum += num
            max_sum = max(max_sum, cur_sum)

        return max_sum
