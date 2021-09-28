from typing import List


class Solution:
    """Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
    search target in nums. If target exists, then return its index. Otherwise, return -1.
    You must write an algorithm with O(log n) runtime complexity."""

    def search(self, nums: List[int], target: int) -> int:
        return self.iterative_binary_search(nums, target)

    def recursive_binary_search(self, nums: List[int], target: int, low: int, high: int) -> int:
        if high >= low:

            # compute middle index
            mid = (high + low) // 2

            # if element is present at the middle itself - return mid index
            if nums[mid] == target:
                return mid

            # If element is smaller than mid, then it can only
            # be present in left subarray
            if nums[mid] > target:
                return self.recursive_binary_search(nums, target, low, mid - 1)

            # Else the element can only be present in right subarray
            if nums[mid] < target:
                return self.recursive_binary_search(nums, target, mid + 1, high)
        else:
            return -1

    def iterative_binary_search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1
        mid = 0

        while low <= high:
            mid = (high + low) // 2

            # If x is greater, ignore left half
            if nums[mid] < target:
                low = mid + 1

            # If x is smaller, ignore right half
            elif nums[mid] > target:
                high = mid - 1

            # means x is present at mid
            else:
                return mid

        # If we reach here, then the element was not present
        return -1


test = [-1, 0, 3, 5, 9, 12]
target = 9

solution = Solution()
print(solution.search(test, 9))
