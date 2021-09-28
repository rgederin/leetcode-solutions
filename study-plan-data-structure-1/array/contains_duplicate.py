from typing import List


# Runtime: 112 ms, faster than 93.71% of Python3 online submissions for Contains Duplicate.
# Memory Usage: 19.9 MB, less than 87.90% of Python3 online submissions for Contains Duplicate.
def contains_duplicates_using_set(nums: List[int]) -> bool:
    unique_set = set()

    for num in nums:
        if num in unique_set:
            return True
        else:
            unique_set.add(num)

    return False


# Runtime: 124 ms, faster than 54.34% of Python3 online submissions for Contains Duplicate.
# Memory Usage: 18.6 MB, less than 98.53% of Python3 online submissions for Contains Duplicate.
def contains_duplicate_using_sort(nums: List[int]) -> bool:
    nums.sort()
    tmp = None

    for num in nums:
        if num == tmp:
            return True
        else:
            tmp = num

    return False
