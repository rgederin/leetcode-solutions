from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        return self.using_map(nums, target)

    # Runtime: 9508 ms, faster than 5.01% of Python3 online submissions for Two Sum.
    # Memory Usage: 14.8 MB, less than 92.58% of Python3 online submissions for Two Sum.
    def brute_force(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1):
            for j in range(1, len(nums)):
                if i != j and nums[i] + nums[j] == target:
                    return [i, j]

    # Runtime: 56 ms, faster than 90.54% of Python3 online submissions for Two Sum.
    # Memory Usage: 15.7 MB, less than 9.53% of Python3 online submissions for Two Sum.
    def using_map(self, nums: List[int], target: int) -> List[int]:
        tmp_dict = {}

        for i in range(len(nums) - 1):
            if nums[i] in tmp_dict:
                return [i, tmp_dict[nums[i]]]

            diff = target - nums[i]
            tmp_dict[diff] = i
